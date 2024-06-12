package com.bosch.example.impl;

import org.springframework.http.ResponseEntity;

public record Cep(String cep, String cidade, Boolean isValid, ResponseEntity<String> response) {}
