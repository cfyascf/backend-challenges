package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.UserData;

public interface UserValidation {
    boolean validate(UserData user, List<String> erroList);
}