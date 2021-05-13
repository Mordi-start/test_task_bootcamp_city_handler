package ru.dmitrymorel.city_directory_handler.dao;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.dmitrymorel.city_directory_handler.controllers.CityController;
import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CityDAOImplTest extends TestCase {

    public void testParseFile() throws IOException {
        CityController cityController = new CityController();
        File file = new File("/Users/a19188814/Desktop/test_task/src/test/java/Test1.txt");

        List<City> expected = cityController.parseFile(file);

        City city1 = new City("Александровск-Сахалинский","Сахалинская область","Дальневосточный",10613,"1869");
        City city2 = new City("Амурск","Хабаровский край","Дальневосточный",42977,"1958");
        City city3 = new City("Агидель","Башкортостан","Приволжский",163345665,"1980");
        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);

        assertEquals(expected, actual);
    }

    public void testSortCitiesByName() {
        CityController cityController = new CityController();
        City city1 = new City("Moscow", "Region", "CAO", 132
                , "3212");
        City city2 = new City("Aoscow", "Region", "CAO", 132
                , "3212");
        City city3 = new City("Boscow", "Region", "CAO", 132
                , "3212");

        List<City> actual = Arrays.asList(city2, city3, city1);
        List<City> expected = cityController.sortCitiesByName(actual);

        assertEquals(expected, actual);
    }

    public void testSortCitiesByDistrictAndName() {
        CityController cityController = new CityController();
        City city1 = new City("Moscow", "Region", "Дальневосточный", 132
                , "3212");
        City city2 = new City("Aoscow", "Region", "Дальневосточный", 132
                , "3212");
        City city3 = new City("Boscow", "Region", "Сибирский", 132
                , "3212");
        City city4 = new City("doscow", "Region", "Сибирский", 132
                , "3212");
        City city5 = new City("Doscow", "Region", "Сибирский", 132
                , "3212");

        List<City> actual = Arrays.asList(city2, city1, city3, city5, city4);
        List<City> expected = cityController.sortCitiesByDistrictAndName(actual);

        Assert.assertEquals(expected, actual);
    }

    public void testFindMaxPopulation() {
        CityController cityController = new CityController();
        City city1 = new City("Moscow", "Region", "BAO", 13132
                , "3212");
        City city2 = new City("Aoscow", "Region", "AAO", 13214334
                , "3212");
        City city3 = new City("Boscow", "Region", "CAO", 1345332
                , "3212");
        City city4 = new City("doscow", "Region", "CAO", 364132
                , "3212");
        City city5 = new City("Doscow", "Region", "AAO", 1332
                , "3212");

        List<City> cityList = Arrays.asList(city1, city2, city3, city4, city5);


        int[] expected = cityController.findMaxPopulation(cityList);
        int expected1 = expected[0];
        int expected2 = expected[1];
        int[] actual = {1, 13214334};
        int actual1 = actual[0];
        int actual2 = actual[1];

        assertEquals(expected1, expected1);
        assertEquals(expected2, expected2);
    }

    public void testCountOfCitiesInRegion() {
        CityController cityController = new CityController();
        City city1 = new City("Moscow", "Region1", "BAO", 13132
                , "3212");
        City city2 = new City("Aoscow", "Region1", "AAO", 13214334
                , "3212");
        City city3 = new City("Boscow", "Region2", "CAO", 1345332
                , "3212");
        City city4 = new City("doscow", "Region3", "CAO", 364132
                , "3212");
        City city5 = new City("Doscow", "Region3", "AAO", 1332
                , "3212");

        List<City> cityList = Arrays.asList(city1, city2, city3, city4, city5);

        Map<String, Integer> expected = cityController.countOfCitiesInRegion(cityList);
        Map<String, Integer> actual = new HashMap<>();
        actual.put("Region1", 2);
        actual.put("Region2", 1);
        actual.put("Region3", 2);

        assertEquals(expected,actual);
    }
}