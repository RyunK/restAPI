package com.example.restapi.service;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;

// 통합 테스트 : service -> repository
@Slf4j
@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserServiceTest {

    private final UserService userService;

    @Test
    @DisplayName("사용자 전체 조회 테스트 : service")
    public void readAllUserTest() {
        // Given
        // When
        ArrayList<FindAllUserDTO> users = userService.readAllUser();
        // Then
        log.info("users = {}", users);
        assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("특정 사용자 조회 테스트 : service")
    public void readByUseridTest() {
        // Given
        String userid = "987xyz";
        // When
        User user = userService.readByUserid(userid);
        // Then
        log.info("user = {}", user);
        assertThat(user).isNotNull();
    }

}