package com.example.restapi.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserControllerTest {

    private final MockMvc mockMvc;

    @Test
    @DisplayName("사용자 전체 조회 테스트 : controller")
    public void getAllUsers() throws Exception {
        // Given
        // When
        mockMvc.perform(get("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)) // 응답 컨텐츠 유형 확인
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$.length()").value(3))
            .andDo(print());
        // Then
    }

    @Test
    @DisplayName("특정 사용자 조회 테스트 : controller")
    public void getUserById() throws Exception {
        // Given
         String userid = "abc123";
        // When
        mockMvc.perform(get("/api/v2/users/{userid}", userid)
                        .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userid").value(userid))
            .andDo(print());
        // Then
    }

}