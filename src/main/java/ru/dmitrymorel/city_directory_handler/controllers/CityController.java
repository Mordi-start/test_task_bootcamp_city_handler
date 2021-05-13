package ru.dmitrymorel.city_directory_handler.controllers;

import ru.dmitrymorel.city_directory_handler.models.City;
import ru.dmitrymorel.city_directory_handler.service.CityService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class CityController {

    private CityService cityService;

    public CityController() {
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
