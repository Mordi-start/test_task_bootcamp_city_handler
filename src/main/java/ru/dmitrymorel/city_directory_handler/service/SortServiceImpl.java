package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortServiceImpl implements SortService{

    /**
     * Метод сортирует города по названию в алфавмтном порядке по убыванию с учетом регистра
     * @param cityList - справочник городов
     */
    @Override
    public List<City> sortCitiesByName(List<City> cityList) {
        return cityList.stream().sorted(Comparator.comparing(x -> (x.getName().toUpperCase())))
                .collect(Collectors.toList());
    }

    /**
     * Метод сортирует города по округу и названию в алфавмтном порядке по убыванию без учета регистра
     * @param cityList - справочник городов
     */
    @Override
    public List<City> sortCitiesByDistrictAndName(List<City> cityList) {
        return cityList.stream().sorted(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName)).collect(Collectors.toList());
    }
}
