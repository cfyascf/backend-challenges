package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.City;
import com.bosch.example.services.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CitiesCintroller {
    @Autowired
    CityService service;

    @GetMapping("/cities")
    public List<City> getMethodName () {
        return service.getAllCities();
    }

    @GetMapping("/cities/{search}")
    public City getMethodName(@RequestParam String search) {
        return service.getCityByName(search);
    }
    
}
