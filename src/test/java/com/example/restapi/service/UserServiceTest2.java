package com.example.restapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)  // 단위 테스트 : service
public class UserServiceTest2 {

    @Mock // 모의 UserRepository 객체
    private UserRepository userRepository;

    @InjectMocks  // 모의 객체로 생성시 대상은 클래스 유형으로 지정
    private UserServiceImpl userService;

    @Test
    @DisplayName("사용자 전체 조회 테스트 : service2")
    public void readAllUserTest() {
        // Given
        FindAllUserDTO user1 = new FindAllUserDTO("abc123","abc123@abc123.co.kr","2025-05-17");
        FindAllUserDTO user2 = new FindAllUserDTO("987xyz","987xyz@987xyz.com","2025-05-23");
        FindAllUserDTO user3 = new FindAllUserDTO("zzyzzy","zzyzzy@zzyzzy.co.kr","2025-05-20");

        List<FindAllUserDTO> users = new ArrayList<>(Arrays.asList(user1, user2, user3));
        when(userRepository.findAlluser()).thenReturn(users);

        // When
        ArrayList<FindAllUserDTO> result = userService.readAllUser();

        // Then
        log.info("users = {}", users);
        assertThat(result).isNotNull();
        assertThat(users.size()).isGreaterThan(0);
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("특정 사용자 조회 테스트 : service2")
    public void readByUseridTest() {
        // Give
        String userid = "zzyzzy";
        User user = new User("zzyzzy","zzyzzy","zzyzzy","zzyzzy@zzyzzy.co.kr","2025-05-20");
        given(userRepository.findByUserid(userid)).willReturn(user);
        //when(userRepository.findByUserid(userid)).thenReturn(user);

        // When
        User result = userService.readByUserid(userid);

        // Then
        log.info("result = {}", result);
        assertThat(result).isNotNull();
        assertThat(result.getUserid()).isEqualTo(userid);
        assertThat(result.getName()).isEqualTo("zzyzzy");
        assertThat(result.getCreatedAt()).isEqualTo("2025-05-20");
    }

}