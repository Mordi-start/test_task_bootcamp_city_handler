package ru.dmitrymorel.city_directory_handler;

import ru.dmitrymorel.city_directory_handler.controllers.CityController;
import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CityController cityController = new CityController();

        List<City> cityList =
                cityController.parseFile(new File("src/main/resources/Cities.txt"));

        cityList.forEach(System.out::println);
        System.out.println("===========================");

        cityController.sortCitiesByName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        cityController.sortCitiesByDistrictAndName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        int[] array = cityController.findMaxPopulation(cityList);
        System.out.println("[" + array[0] + "] = " + array[1]);
        System.out.println("===========================");

        cityController.countOfCitiesInRegion(cityList).forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
