package ru.dmitrymorel.city_directory_handler.service;

import ru.dmitrymorel.city_directory_handler.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DialogServiceImpl implements DialogService{

    @Override
    public void dialog() {
        ParserService parserService = new ParserServiceImpl();
        CityService cityService = new CityServiceImpl();
        SortService sortService = new SortServiceImpl();
        SearchService searchService = new SearchServiceImpl();
        GroupingService groupingService = new GroupingServiceImpl();

        String dialog = "Выбери действие:\n" +
                "1. Внести данные из файла в базу данных\n" +
                "2. Показать список всех городов\n" +
                "3. Найти город\n" +
                "4. Изменить информацию о городе\n" +
                "5. Удалить город\n" +
                "6. Отсортировать города по названию\n" +
                "7. Отсортировать города по округу\n" +
                "8. Найти город с самой большой популяцией\n" +
                "9. Показать количество городов по регионам\n" +
                "10. Показать меню\n" +
                "\"q\" - для выхода\n";

        System.out.println(dialog);

        Scanner console = new Scanner(System.in);
        List<City> cityList = cityService.findAll();

        String number;
        while (!(number = console.nextLine()).equals("q")) {
            switch (number) {
                case "1": {
                    System.out.println("Введите путь к файлу:");
                    try {
                        cityList = parserService.parseFile(new File(console.nextLine()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    cityList.forEach(cityService::saveCity);
                    break;
                }
                case "2": {
                    cityList.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("Введите название города:");
                    System.out.println(cityService.getCity(console.nextLine()));
                    break;
                }
                case "4": {
                    System.out.println("Введите название города, который хотите изменить:");
                    String name = console.nextLine();

                    System.out.println("Введите новое название:");
                    String updateName = console.nextLine();

                    System.out.println("Введите новый регион:");
                    String updateRegion = console.nextLine();

                    System.out.println("Введите новый округ:");
                    String updateDistrict = console.nextLine();

                    System.out.println("Введите новую популяцию:");
                    int updatePopulation = console.nextInt();

                    System.out.println("Введите новую дату основания:");
                    String updateFoundation = console.nextLine();

                    City updateCity = new City(updateName, updateRegion, updateDistrict,
                            updatePopulation, updateFoundation);

                    cityService.updateCity(name, updateCity);

                    break;
                }
                case "5": {
                    System.out.println("Введите название города, который хотите удалить");
                    String name = console.nextLine();
                    cityService.deleteCity(name);
                    break;
                }
                case "6": {
                    cityList = sortService.sortCitiesByName(cityList);
                    if (cityList != null) {
                        cityList.forEach(System.out::println);
                    }
                    else {
                        System.out.println("Список пуст");
                    }
                    break;
                }
                case "7": {
                    cityList = sortService.sortCitiesByDistrictAndName(cityList);
                    if (cityList != null) {
                        cityList.forEach(System.out::println);
                    }
                    else {
                        System.out.println("Список пуст");
                    }
                    break;
                }
                case "8": {
                    int[] population = searchService.findMaxPopulation(cityList);
                    System.out.println("[" + population[0] + "] = " + population[1]);
                    break;
                }
                case "9": {
                    groupingService.countOfCitiesInRegion(cityList).forEach((k, v) -> System.out.println(k + " - " + v));
                    break;
                }
                case "10": {
                    System.out.println(dialog);
                    break;
                }
//                case "11": {
//                    break;
//                }
                default:
                    System.out.println("Введено некорректное значение");
            }
        }
        console.close();
    }
}
