package ru.dmitrymorel.city_directory_handler.controllers;

import ru.dmitrymorel.city_directory_handler.models.City;
import ru.dmitrymorel.city_directory_handler.service.CityService;
import ru.dmitrymorel.city_directory_handler.service.CityServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class CityController {

    private final CityService cityService = new CityServiceImpl();

    public CityController() {
    }

    public void createTable() {
        cityService.createTable();
    }

    public List<City> findAll() {
        return cityService.findAll();
    }

    public City getCity(String name) {
        return cityService.getCity(name);
    }

    public void saveCity(City city) {
        cityService.saveCity(city);
    }

    public void updateCity(String name, City city) {
        cityService.updateCity(name, city);
    }

    public void deleteCity(String name) {
        cityService.deleteCity(name);
    }


    public List<City> parseFile(File file) throws FileNotFoundException {
        return cityService.parseFile(file);
    }

    public List<City> sortCitiesByName(List<City> cityList) {
        return cityService.sortCitiesByName(cityList);
    }

    public List<City> sortCitiesByDistrictAndName(List<City> cityList) {
        return cityService.sortCitiesByDistrictAndName(cityList);
    }

    public int[] findMaxPopulation(List<City> cityList) {
        return cityService.findMaxPopulation(cityList);
    }

    public Map<String, Integer> countOfCitiesInRegion(List<City> cityList) {
        return cityService.countOfCitiesInRegion(cityList);
    }
}
