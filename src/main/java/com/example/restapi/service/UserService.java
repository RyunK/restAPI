package com.example.restapi.service;

import java.util.ArrayList;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.domain.UserCreateDTO;

public interface UserService {

    ArrayList<FindAllUserDTO> readAllUser();
    User readByUserid(String userid);
		boolean newUser(UserCreateDTO user);
		
}