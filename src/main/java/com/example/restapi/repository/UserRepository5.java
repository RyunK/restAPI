package com.example.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.domain.User3;

@Repository
public interface UserRepository5 extends JpaRepository<User3, String> {
    Optional<User3> findByEmail(String email);
    boolean existsByEmail(String email);
}

