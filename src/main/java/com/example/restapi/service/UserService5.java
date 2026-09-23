package com.example.restapi.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.restapi.domain.User3;

public interface UserService5 {

    ArrayList<User3> readAllUser();
    Optional<User3> readByUserid(String userid);
    User3 newUser(User3 user);

}