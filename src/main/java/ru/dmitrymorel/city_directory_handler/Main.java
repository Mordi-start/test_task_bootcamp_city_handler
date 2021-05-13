package ru.dmitrymorel.city_directory_handler;

import ru.dmitrymorel.city_directory_handler.models.City;
import ru.dmitrymorel.city_directory_handler.service.CityService;
import ru.dmitrymorel.city_directory_handler.service.CityServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CityService cityService = new CityServiceImpl();

        List<City> cityList =
                cityService.parseFile(new File("src/main/resources/Cities.txt"));

        cityList.forEach(System.out::println);
        System.out.println("===========================");

        cityService.sortCitiesByName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        cityService.sortCitiesByDistrictAndName(cityList).forEach(System.out::println);
        System.out.println("===========================");

        int[] array = cityService.findMaxPopulation(cityList);
        System.out.println("[" + array[0] + "] = " + array[1]);
        System.out.println("===========================");

        cityService.countOfCitiesInRegion(cityList).forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
