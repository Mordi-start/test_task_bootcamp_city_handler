package ru.dmitrymorel.city_directory_handler;

import ru.dmitrymorel.city_directory_handler.controllers.CityController;
import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        CityController cityController = new CityController();
        List<City> cityList = new ArrayList<>();

        cityController.dialog();

//        cityList = cityController.parseFile(new File("src/main/resources/Cities.txt"));

        /*cityList.forEach(System.out::println);
        System.out.println("===========================");

        cityController.sortCitiesByName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        cityController.sortCitiesByDistrictAndName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        int[] array = cityController.findMaxPopulation(cityList);
        System.out.println("[" + array[0] + "] = " + array[1]);
        System.out.println("===========================");

        cityController.countOfCitiesInRegion(cityList).forEach((k, v) -> System.out.println(k + " - " + v));*/

//        cityController.createTable();
//
//



//        System.out.println(cityController.getCity("Майкоп"));
//        cityController.updateCity("Майкоп", new City("Майкоп","qwer", "agd", 234, "gdfs"));
//        System.out.println(cityController.getCity("Майкоп"));
//        cityController.deleteCity("Майкоп");
//        System.out.println(cityController.getCity("Майкоп"));
//
//        System.out.println("===========================");
//
//        List<City> cityList2 = cityController.findAll();
//        cityList2.forEach(System.out::println);
    }
}
