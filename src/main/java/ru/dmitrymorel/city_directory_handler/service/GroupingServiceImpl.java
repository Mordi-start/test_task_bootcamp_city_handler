package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingServiceImpl implements GroupingService{
    /**
     * Метод ищет кол-во городов в разрезе регионов
     * @param cityList - справочник городов
     */
    @Override
    public Map<String, Integer> countOfCitiesInRegion(List<City> cityList) {
        Map<String, List<City>> cityMap =  cityList.stream().collect(Collectors
                .groupingBy(City::getRegion));
        Map<String, Integer> returnedMap = new HashMap<>();
        for (Map.Entry<String, List<City>> entry : cityMap.entrySet()) {
            returnedMap.put(entry.getKey(), entry.getValue().size());
        }
        return returnedMap;
    }
}
