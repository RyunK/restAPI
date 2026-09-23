package com.example.restapi.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserCreateDTO2 {

    @NotBlank(message="아이디는 필수입니다")
    @Size(min=6, max=18, message="아이디는 6자 이상 18자 이하로 입력하세요")
    private String userid;

    @NotBlank(message="비밀번호는 필수입니다")
    @Size(min=6, max=18, message="비밀번호는 6자 이상 18자 이하로 입력하세요")
    private String passwd;

    @NotBlank(message="이름은 필수입니다")
    private String name;

    @NotBlank(message="이메일은 필수입니다")
    @Email(message="올바른 이메일 형식이 아닙니다")
    private String email;

    @NotBlank(message="전화번호는 필수입니다")
    @Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message="올바른 전화번호 형식이 아닙니다")
    private String phone;

}

