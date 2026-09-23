package com.example.restapi.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.example.restapi.domain.UserCreateDTO2;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    // 회원정보 초기화 (임시 데이터)
    private final List<User> users = new ArrayList<>(
        Arrays.asList(
            new User("abc123","987xyz","abc123","abc123@abc123.co.kr","2025-05-17"),
            new User("987xyz","abc123","987xyz","987xyz@987xyz.com","2025-05-23"),
            new User("zzyzzy","zzyzzy","zzyzzy","zzyzzy@zzyzzy.co.kr","2025-05-20")
        )
    );

    // 모든 사용자 조회
    // localhost:8080/api/v1/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        
        return ResponseEntity.ok(users);
    }

    // 특정 id로 사용자 식별 - 경로변수로 사용자 검색
    // localhost:8080/api/v1/users/아이디
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable String userid) {
        Optional<User> userOptional = users.stream()
            .filter(user -> user.getUserid().equals(userid)).findFirst();

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get()); // 200
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    // 새로운 회원 추가
    // localhost:8080/api/v1/users
    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody User user) {
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED); // 201
    }

    // 사용자 정보 전체 수정
    // localhost:8080/api/v1/users/아이디
    @PutMapping("/{userid}")
    public ResponseEntity<User> modifyUser(
		    @PathVariable String userid, @RequestBody User user) {
        Optional<User> userOptional = users.stream()
            .filter(usr -> usr.getUserid().equals(userid)).findFirst();

        if (userOptional.isPresent()) {
            // 사용자 정보 수정
            User existUser = userOptional.get();
            users.remove(existUser);  // 기존 데이터 삭제
            users.add(user);  // 새로운 데이터 추가

            return ResponseEntity.ok(user); // 200
        } else {
            return ResponseEntity.notFound().build();  // 404
        }
    }

    // 사용자 정보 일부 수정
    // localhost:8080/api/v1/users/아이디
    @PatchMapping("/{userid}")
    public ResponseEntity<User> patchUser(
            @PathVariable String userid, @RequestBody User user) {
        Optional<User> userOptional = users.stream()
            .filter(usr -> usr.getUserid()
                    .equals(userid)).findFirst();

        if (userOptional.isPresent()) {
            User existUser = userOptional.get();
            users.remove(existUser);  // 기존 데이터 삭제

            // 이름, 이메일 부분 수정
            existUser.setName(user.getName());
            existUser.setEmail(user.getEmail());
            users.add(existUser);    // 수정된 데이터 추가

            return ResponseEntity.ok(user);  // 200
        } else {
            return ResponseEntity.noContent().build();  // 204
        }

    }

    // 사용자 삭제
    // localhost:8080/api/v1/users/아이디
    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userid) {
        boolean removed = users.removeIf(
                user -> user.getUserid().equals(userid));

        if (removed) {
            return ResponseEntity.noContent().build();  // 204
        } else {
            return ResponseEntity.notFound().build();   // 404
        }
    }

    // 새로운 회원 추가 2
    // localhost:8080/api/v1/users/valid
    @PostMapping("/valid")
    public ResponseEntity<?> newUser2(
            @Valid @RequestBody UserCreateDTO2 user,
            BindingResult result) {
        log.info("newUser2 호출됨!! : {}", user);
        log.info("유효성 검사 메세지 : {}", result);

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
                log.info("errors : {}", errors);
            }

            return ResponseEntity.badRequest().body(errors);  // 400
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED); // 201
    }

}
