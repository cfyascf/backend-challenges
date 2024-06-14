package com.bosch.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    List<UserData> findByUsername(String username);
}
