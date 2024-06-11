package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.Imaexp;
import com.bosch.example.services.ImaexpService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ImaexpController {
    @Autowired 
    ImaexpService service;

    @GetMapping("/imaexp")
    public Imaexp getImaexp(@RequestParam Integer A, @RequestParam Integer b) {
        return service.calcImaexp(A, b);
    }
}
