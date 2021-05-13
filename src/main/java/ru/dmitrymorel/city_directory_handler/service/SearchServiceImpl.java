package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.List;

public class SearchServiceImpl implements SearchService{


    /**
     * Метод ищет индекс города и значение популяции среди всех городов в справочнике с максимальным количеством жителей
     * @param cityList - справочник городов
     */
    @Override
    public int[] findMaxPopulation(List<City> cityList) {
        City[] cities = cityList.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].getPopulation() > max) {
                max = cities[i].getPopulation();
                index = i;
            }
        }
        return new int[]{index, max};
    }
}
