package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.dao.CityDAO;
import ru.dmitrymorel.city_directory_handler.dao.CityDAOImpl;
import ru.dmitrymorel.city_directory_handler.models.City;

import java.util.List;

public class CityServiceImpl implements CityService{

    private final CityDAO cityDAO = new CityDAOImpl();


    @Override
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public void saveCity(City city) {
        cityDAO.saveCity(city);
    }

    @Override
    public City getCity(String name) {
        return cityDAO.getCity(name);
    }

    @Override
    public void deleteCity(String name) {
        cityDAO.deleteCity(name);
    }

    @Override
    public void createTable() {
        cityDAO.createTable();
    }

    @Override
    public void updateCity(String name, City city) {
        cityDAO.updateCity(name, city);
    }
}
