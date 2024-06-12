package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.Cep;
import com.bosch.example.services.CuritibaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CuritibaController {
    @Autowired
    CuritibaService service;

    @GetMapping("/curitiba")
    public Cep getCuritiba(@RequestParam String cep) {
        return service.getCpfRequest(cep);
    }
    
}
