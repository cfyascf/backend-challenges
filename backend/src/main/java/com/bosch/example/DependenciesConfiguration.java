package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.CityImplementation;
import com.bosch.example.impl.CollatzImplementation;
import com.bosch.example.impl.DefaultUserValidation;
import com.bosch.example.impl.EmailFormatUserValidation;
import com.bosch.example.impl.EmailSizeUserValidation;
import com.bosch.example.impl.ImaexpImplementation;
import com.bosch.example.impl.PalindromoImplementation;
import com.bosch.example.repository.CityRepository;
import com.bosch.example.services.CityService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.ImaexpService;
import com.bosch.example.services.PalindromoService;
import com.bosch.example.services.UserValidation;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public UserValidation userValidation() {
        DefaultUserValidation validator = new DefaultUserValidation();
        
        validator.add(new EmailSizeUserValidation());
        validator.add(new EmailFormatUserValidation());

        return validator;
    }
    
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

    @Bean
    @Scope("singleton")
    public CityService cityService(){
        return new CityImplementation();
    }

}
