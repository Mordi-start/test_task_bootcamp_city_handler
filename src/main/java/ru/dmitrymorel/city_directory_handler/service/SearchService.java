package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.List;

public interface SearchService {

    int[] findMaxPopulation(List<City> cityList);

}
