package com.bosch.example.impl;

import java.util.List;

import com.bosch.example.model.UserData;
import com.bosch.example.services.UserValidation;

public class EmailSizeUserValidation implements UserValidation {

    @Override
    public boolean validate(UserData user, List<String> erroList) {
        
        var email = user.getEmail();
        if(email != null && email.length() > 3)
            return true;
        
        erroList.add("Email is empty or too short.\n");
        return false;
    }
    
}
