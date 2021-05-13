package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.List;
import java.util.Map;

public interface SearchService {

    int[] findMaxPopulation(List<City> cityList);

}
