package ru.dmitrymorel.city_directory_handler;

import ru.dmitrymorel.city_directory_handler.controllers.CityController;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        CityController cityController = new CityController();

        cityController.dialog();

    }
}
