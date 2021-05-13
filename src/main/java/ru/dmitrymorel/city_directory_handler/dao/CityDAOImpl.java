package ru.dmitrymorel.city_directory_handler.dao;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class CityDAOImpl implements CityDAO{
    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public void saveCity(City employee) {

    }

    @Override
    public City getCity(int id) {
        return null;
    }

    @Override
    public void deleteCity(int id) {

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
