package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.Palindromo;
import com.bosch.example.services.PalindromoService;


@RestController
public class PalindromoController {
    @Autowired
    PalindromoService service;

    @GetMapping("/reverse/{string}")
    public Palindromo isPalindromo(@PathVariable String string) {
        return service.reverse(string);
    }
}   