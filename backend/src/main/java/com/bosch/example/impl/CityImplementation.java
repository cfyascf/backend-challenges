package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.example.model.City;
import com.bosch.example.repository.CityRepository;
import com.bosch.example.services.CityService;

public class CityImplementation implements CityService
{
    @Autowired
    CityRepository repo;

    @Override
    public List<City> findAll() {
        return repo.findAll();
    }

    @Override
    public City findByNameContaining(String search) {
        return repo.findByNameContaining(search);
    }

}
