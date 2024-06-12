package com.bosch.example.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.services.CollatzService;

public class CollatzImplementation implements CollatzService {

    @Override
    public Collatz calcCollatz(Integer current, Integer step) {
        double result = (double) current;

        if(current < 0 || step < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        for(int i = 0; i < step; i++) {
            if(current % 2 == 0) {
                result /= 2;
            } else {
                result = (3 * result) + 1;
            }
        }

        return new Collatz((int) result, step);
    }
    
}
