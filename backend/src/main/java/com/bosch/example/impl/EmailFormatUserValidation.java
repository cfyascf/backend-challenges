package com.bosch.example.impl;

import java.util.List;

import com.bosch.example.model.UserData;
import com.bosch.example.services.UserValidation;

public class EmailFormatUserValidation implements UserValidation {

    @Override
    public boolean validate(UserData user, List<String> erroList) {
        var email = user.getEmail();
        if(email.chars().anyMatch(c -> c == '@'))
            return true;
            
        erroList.add("Email is invalid.\n");
        return false;
    }
    
}