package com.example.restapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/users")
public class UserController2 {

    private final UserService userService;

    // 모든 사용자 조회
    // localhost:8080/api/v2/users
    @GetMapping
    public ResponseEntity<List<FindAllUserDTO>> getAllUsers() {
        log.info("getAllUsers 호출됨!!");

        List<FindAllUserDTO> users = userService.readAllUser();

        return ResponseEntity.ok(users);
    }

    // 특정 id로 사용자 식별 - 경로변수로 사용자 검색
    // localhost:8080/api/v2/users/아이디
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable String userid) {
        log.info("getUserById 호출됨!!");

        User user = userService.readByUserid(userid);

        if (user != null) {
            return ResponseEntity.ok(user); // 200
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

}