package com.example.restapi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.domain.UserCreateDTO;
import com.example.restapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service              // IoC 관리 대상 지정
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ArrayList<FindAllUserDTO> readAllUser() {
        return (ArrayList<FindAllUserDTO>) userRepository.findAlluser();
    }

    @Override
    public User readByUserid(String userid) {
        return userRepository.findByUserid(userid);
    }
    
    @Override
    public boolean newUser(UserCreateDTO user) {
        return userRepository.insertUser(user) > 0 ? true : false;
    }

}