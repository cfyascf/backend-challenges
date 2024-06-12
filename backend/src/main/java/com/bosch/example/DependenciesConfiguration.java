package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.CollatzImplementation;
import com.bosch.example.impl.ImaexpImplementation;
import com.bosch.example.impl.PalindromoImplementation;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.ImaexpService;
import com.bosch.example.services.PalindromoService;

@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public PalindromoService palindromoService() {
        return new PalindromoImplementation();
    }

    @Bean
    @Scope("singleton")
    public ImaexpService imaexpService() {
        return new ImaexpImplementation();
    }

    @Bean
    @Scope("singleton")
    public CollatzService collatzService() {
        return new CollatzImplementation();
    }

}
