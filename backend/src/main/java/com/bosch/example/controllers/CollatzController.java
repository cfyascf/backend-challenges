package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.Collatz;
import com.bosch.example.services.CollatzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CollatzController {
    @Autowired
    CollatzService collatz;
    
    @GetMapping("/collatz")
    public Collatz getCollatz(@RequestParam Integer current, @RequestParam Integer step) {
        
        return collatz.calcCollatz(current, step);
    }
    
}
