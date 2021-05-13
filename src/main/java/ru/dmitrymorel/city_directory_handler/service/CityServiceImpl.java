package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.dao.CityDAO;
import ru.dmitrymorel.city_directory_handler.dao.CityDAOImpl;
import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class CityServiceImpl implements CityService{

    private CityDAO cityDAO = new CityDAOImpl();


    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public void saveCity(City employee) {

    }

    @Override
    public City getCity(int id) {
        return null;
    }

    @Override
    public void deleteCity(int id) {

    }

    @Override
    public List<City> parseFile(File file) throws FileNotFoundException {
        return cityDAO.parseFile(file);
    }

    @Override
    public List<City> sortCitiesByName(List<City> cityList) {
        return cityDAO.sortCitiesByName(cityList);
    }

    @Override
    public List<City> sortCitiesByDistrictAndName(List<City> cityList) {
        return cityDAO.sortCitiesByDistrictAndName(cityList);
    }

    @Override
    public int[] findMaxPopulation(List<City> cityList) {
        return cityDAO.findMaxPopulation(cityList);
    }

    @Override
    public Map<String, Integer> countOfCitiesInRegion(List<City> cityList) {
        return cityDAO.countOfCitiesInRegion(cityList);
    }
}
