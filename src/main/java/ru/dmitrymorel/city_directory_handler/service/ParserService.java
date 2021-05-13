package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ParserService {
    List<City> parseFile(File file) throws FileNotFoundException;
}
