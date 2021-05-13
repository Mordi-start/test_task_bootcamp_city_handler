package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserServiceImpl implements ParserService{
    /**
     * Метод заполняет список городов, читая значения из файла, исполузуемого в сканере
     * @param file - исследуемый файл
     * @throws FileNotFoundException - файл не найден
     */
    @Override
    public List<City> parseFile(File file) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(file);
        List<City> cityList = new ArrayList<>();
        fileScanner.useDelimiter(";");
        while (fileScanner.hasNext()) {
            fileScanner.next();
            String name = fileScanner.next();
            String region = fileScanner.next();
            String district = fileScanner.next();
            int population = fileScanner.nextInt();
            String foundation = fileScanner.next();
            cityList.add(new City(name, region, district, population, foundation));
        }
        fileScanner.close();
        return cityList;
    }
}
