package ru.dmitrymorel.city_directory_handler.models;

import java.util.Objects;

public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundationDate;

    public City() {}

    public City(String name, String region, String federalDistrict, int population, String foundationDate) {
        this.name = name;
        this.region = region;
        this.district = federalDistrict;
        this.population = population;
        this.foundationDate = foundationDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundationDate='" + foundationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name)
                && Objects.equals(region, city.region) && Objects.equals(district, city.district)
                && Objects.equals(foundationDate, city.foundationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundationDate);
    }
}
