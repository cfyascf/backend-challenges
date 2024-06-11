package com.bosch.example.impl;

import com.bosch.example.services.ImaexpService;

public class ImaexpImplementation implements ImaexpService {

    @Override
    public Imaexp calcImaexp(Integer a, Integer b) {        
        Double re = a * Math.sin(b);
        Double im = a * Math.cos(b);

        return new Imaexp(re, im);
    }
    
}
