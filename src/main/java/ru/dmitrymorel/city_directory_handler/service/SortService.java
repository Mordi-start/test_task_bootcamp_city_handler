package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.List;

public interface SortService {

    List<City> sortCitiesByName(List<City> cityList);

    List<City> sortCitiesByDistrictAndName(List<City> cityList);

}
