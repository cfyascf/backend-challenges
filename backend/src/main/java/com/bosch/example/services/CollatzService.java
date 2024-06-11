package com.bosch.example.services;

import com.bosch.example.impl.Collatz;

public interface CollatzService {
    public Collatz calcCollatz(Integer current, Integer step); 
}
