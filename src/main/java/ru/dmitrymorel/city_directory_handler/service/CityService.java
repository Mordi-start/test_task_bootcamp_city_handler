package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface CityService {

    List<City> findAll();

    void saveCity(City employee);

    City getCity(String name);

    void deleteCity(String name);

    void createTable();

    void updateCity(String name, City city);
}
