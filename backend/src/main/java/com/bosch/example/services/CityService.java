package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.City;

public interface CityService {
    public List<City> getAllCities();
    public City getCityByName(String search);
}
