package ru.dmitrymorel.city_directory_handler.dao;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class CityDAOImpl implements CityDAO{

    static final String DATABASE_URL = "jdbc:h2:~/test";
    static final String USER = "USER";
    static final String PASSWORD = "PASSWORD";

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE CITIES (" +
                    "NAME VARCHAR," +
                    "REGION VARCHAR," +
                    "DISTRICT VARCHAR," +
                    "POPULATION INT," +
                    "FOUNDATION VARCHAR" +
                    ");");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CITIES");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                City city = new City();

                city.setName(resultSet.getString("name"));
                city.setRegion(resultSet.getString("region"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getInt("population"));
                city.setFoundationDate(resultSet.getString("foundation"));

                cities.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cities;
    }

    @Override
    public void saveCity(City city) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO CITIES VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getRegion());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setString(5, city.getFoundationDate());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public City getCity(String name) {
        City city = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM CITIES " +
                    "WHERE name=?");

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            city = new City();

            city.setName(resultSet.getString("name"));
            city.setRegion(resultSet.getString("region"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getInt("population"));
            city.setFoundationDate(resultSet.getString("foundation"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return city;
    }

    @Override
    public void updateCity(String name, City updatedCity) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE CITIES SET NAME=?, REGION=?, DISTRICT=?" +
                            ", POPULATION=?, FOUNDATION=? where name =?");

            preparedStatement.setString(1, updatedCity.getName());
            preparedStatement.setString(2, updatedCity.getRegion());
            preparedStatement.setString(3, updatedCity.getDistrict());
            preparedStatement.setInt(4, updatedCity.getPopulation());
            preparedStatement.setString(5, updatedCity.getFoundationDate());
            preparedStatement.setString(6, name);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String name) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM CITIES WHERE name=?");

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Метод заполняет список городов, читая значения из файла, исполузуемого в сканере
     * @param file - исследуемый файл
     * @throws FileNotFoundException - файл не найден
     */
    @Override
    public List<City> parseFile(File file) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(file);
        List<City> cityList = new ArrayList<>();
        fileScanner.useDelimiter(";");
        while (fileScanner.hasNext()) {
            fileScanner.next();
            String name = fileScanner.next();
            String region = fileScanner.next();
            String district = fileScanner.next();
            int population = fileScanner.nextInt();
            String foundation = fileScanner.next();
            cityList.add(new City(name, region, district, population, foundation));
        }
        fileScanner.close();
        return cityList;
    }

    /**
     * Метод сортирует города по названию в алфавмтном порядке по убыванию с учетом регистра
     * @param cityList - справочник городов
     */
    @Override
    public List<City> sortCitiesByName(List<City> cityList) {
        return cityList.stream().sorted(Comparator.comparing(x -> (x.getName().toUpperCase())))
                .collect(Collectors.toList());
    }

    /**
     * Метод сортирует города по округу и названию в алфавмтном порядке по убыванию без учета регистра
     * @param cityList - справочник городов
     */
    @Override
    public List<City> sortCitiesByDistrictAndName(List<City> cityList) {
        return cityList.stream().sorted(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName)).collect(Collectors.toList());
    }

    /**
     * Метод ищет индекс города и значение популяции среди всех городов в справочнике с максимальным количеством жителей
     * @param cityList - справочник городов
     */
    @Override
    public int[] findMaxPopulation(List<City> cityList) {
        City[] cities = cityList.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].getPopulation() > max) {
                max = cities[i].getPopulation();
                index = i;
            }
        }
        return new int[]{index, max};
    }

    /**
     * Метод ищет кол-во городов в разрезе регионов
     * @param cityList - справочник городов
     */
    @Override
    public Map<String, Integer> countOfCitiesInRegion(List<City> cityList) {
        Map<String, List<City>> cityMap =  cityList.stream().collect(Collectors
                .groupingBy(City::getRegion));
        Map<String, Integer> returnedMap = new HashMap<>();
        for (Map.Entry<String, List<City>> entry : cityMap.entrySet()) {
            returnedMap.put(entry.getKey(), entry.getValue().size());
        }
        return returnedMap;
    }
}
