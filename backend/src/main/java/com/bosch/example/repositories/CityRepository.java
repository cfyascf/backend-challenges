package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
    List<City> findAll();
    City findByNameContaining(String search);
}
