package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.UserData;
import com.bosch.example.repository.UserRepository;
import com.bosch.example.services.UserValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    @Autowired 
    UserRepository repo;

    @Autowired
    UserValidation validator;
    
    @PostMapping("/create")
    public ResponseEntity<String> postRegisterUser(@RequestBody UserData user) {
        ArrayList<String> errorList = new ArrayList<>();
        validator.validate(user, errorList);

        if(!verify(user)) {
            return new ResponseEntity<>("Invalid data :/", HttpStatus.BAD_REQUEST);
        };

        repo.save(user);
        
        return new ResponseEntity<>("User created :)", HttpStatus.OK);
    }

    public String verify(UserData user) {
        StringBuilder sb = new StringBuilder();
        Predicate<IntPredicate> match = f -> user.getPassword().chars().anyMatch(f);

        var username = user.getUsername();
        if(username == null || username.isEmpty() || username.length() < 4 ) {
            sb.append("Username is empty or too short.\n");
        }
        
        var password = user.getPassword();
        if (password == null || password.isEmpty() || password.length() < 8) {
            sb.append("Password is empty or too short.\n");
        }
        
        if(!match.test(Character::isDigit)) {
            sb.append("Password must contains digits.\n");
        }
        
        if(!match.test(Character::isUpperCase)) {
            sb.append("Password must contains uppercase letters.\n");
        }
        
        if(!match.test(Character::isLowerCase)) {
            sb.append("Password must contains lowercase letters.\n");
        }
        
        if(userExists(user)){
            sb.append("User already exists.\n");
        }
        
        return null;
    }

    public Boolean userExists(UserData user) {
        return repo.findByUsername(user.getUsername()).size() > 0;
    }
}