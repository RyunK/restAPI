package com.example.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.domain.User;
import com.example.restapi.domain.User3;
import com.example.restapi.service.UserService5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/users")
public class UserController5 {
    
    private final UserService5 userService;

    // 모든 사용자 조회
    // localhost:8080/api/v1/users
    @GetMapping
    public ResponseEntity<List<User3>> getAllUsers() {
        log.info("getAllUsers 호출됨!!");

        List<User3> users = userService.readAllUser();

        return ResponseEntity.ok(users);
    }

    // 특정 id로 사용자 식별 - 경로변수로 사용자 검색
    // localhost:8080/api/v1/users/아이디
    @GetMapping("/{userid}")
    public ResponseEntity<?> getUserById(@PathVariable String userid) {
        log.info("getUserById 호출됨!!");

        Optional<User3> user = userService.readByUserid(userid);

        return ResponseEntity.ok(user);
    }

    // 새로운 회원 추가
    // localhost:8080/api/v1/users
    @PostMapping
    public ResponseEntity<User3> newUser(@RequestBody User3 user) {
        log.info("newUser 호출됨!!");

        User3 newOne = userService.newUser(user);

        return new ResponseEntity<>(newOne, HttpStatus.CREATED); // 201
    }

    // 사용자 정보 전체 수정
    // localhost:8080/api/v1/users/아이디
    @PutMapping("/{userid}")
    public ResponseEntity<User> modifyUser(
            @PathVariable String userid, @RequestBody User user) {
        log.info("modifyUser 호출됨!!");


        return ResponseEntity.ok(user); // 200

    }

    // 사용자 정보 일부 수정
    // localhost:8080/api/v1/users/아이디
    @PatchMapping("/{userid}")
    public ResponseEntity<User> patchUser(
            @PathVariable String userid, @RequestBody User user) {
        log.info("patchUser 호출됨!!");

        return ResponseEntity.ok(user);  // 200

    }

    // 사용자 삭제
    // localhost:8080/api/v1/users/아이디
    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userid) {
        log.info("deleteUser 호출됨!!");


        return ResponseEntity.noContent().build();  // 204

    }

}
