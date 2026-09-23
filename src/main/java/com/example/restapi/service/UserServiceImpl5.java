package com.example.restapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restapi.domain.User3;
import com.example.restapi.repository.UserRepository5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service   // IoC 관리 대상 지정
@RequiredArgsConstructor
public class UserServiceImpl5 implements UserService5 {

    private final UserRepository5 userRepository;

    @Override
    public ArrayList<User3> readAllUser() {
        return (ArrayList<User3>) userRepository.findAll();
    }

    @Override
    public Optional<User3> readByUserid(String userid) {
        return userRepository.findById(userid);
    }

    @Override
    public User3 newUser(User3 user) {
        return userRepository.save(user);
    }

}
