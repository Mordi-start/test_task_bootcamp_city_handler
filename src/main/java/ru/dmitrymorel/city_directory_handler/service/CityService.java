package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface CityService {

    List<City> findAll();

    void saveCity(City employee);

    City getCity(int id);

    void deleteCity(int id);

    List<City> parseFile(File file) throws FileNotFoundException;

    List<City> sortCitiesByName(List<City> cityList);

    List<City> sortCitiesByDistrictAndName(List<City> cityList);

    int[] findMaxPopulation(List<City> cityList);

    Map<String, Integer> countOfCitiesInRegion(List<City> cityList);
}
