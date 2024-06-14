package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.UserData;

public interface UserService {
    public List<UserData> findAll();
}
