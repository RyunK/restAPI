package com.example.restapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.test.context.TestConstructor;

import com.example.restapi.domain.User;
import com.example.restapi.domain.FindAllUserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MybatisTest
@RequiredArgsConstructor // final 필드변수로 생성자 생성
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserMapperTest {

    // 생성자를 이용한 의존성 주입 사용
    private final UserRepository userRepository;

    @Test
    @DisplayName("사용자 전체 조회 테스트")
    void findAllUsersTest() {
        // Given
        // When
        List<FindAllUserDTO> users = userRepository.findAlluser();
        // Then
        log.info("users = {}", users);
        assert users.size() > 0;
        assertThat(users.size()).isGreaterThan(0);
    }
    
    @Test
    @DisplayName("특정 사용자 조회 테스트")
    void findByUseridTest() {
        // Given
        String userid = "abc123";
        // When
        User user = userRepository.findByUserid(userid);
        // Then
        log.info("user = {}", user);
        assertThat(user).isNotNull();
        assert user != null;
    }

}