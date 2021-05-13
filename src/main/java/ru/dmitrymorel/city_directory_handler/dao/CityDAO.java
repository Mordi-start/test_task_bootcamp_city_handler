package ru.dmitrymorel.city_directory_handler.dao;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface CityDAO {

    void createTable();

    List<City> findAll();

    void saveCity(City employee);

    City getCity(String name);

    void updateCity(String name, City city);

    void deleteCity(String name);

    List<City> parseFile(File file) throws FileNotFoundException;

    List<City> sortCitiesByName(List<City> cityList);

    List<City> sortCitiesByDistrictAndName(List<City> cityList);

    int[] findMaxPopulation(List<City> cityList);

    Map<String, Integer> countOfCitiesInRegion(List<City> cityList);
}
