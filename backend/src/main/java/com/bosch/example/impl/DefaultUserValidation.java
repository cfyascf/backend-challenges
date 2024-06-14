package com.bosch.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.bosch.example.model.UserData;
import com.bosch.example.services.UserValidation;

public class DefaultUserValidation implements UserValidation {

    List<UserValidation> validations = new ArrayList<>();

    public void add(UserValidation validation) {
        validations.add(validation);
    }

    @Override
    public boolean validate(UserData user, List<String> erroList) {
        
        Boolean success = true;
        for (UserValidation validation : this.validations) {
            success &= validation.validate(user, erroList);
        }

        return success;
    }
    
}
