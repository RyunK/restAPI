package com.example.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restapi.domain.UserCreateDTO2;
import com.example.restapi.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController4 {

    private final UserService userService;

    @GetMapping("/newUser2")
    public String newUser(Model model) {
        model.addAttribute("userDTO", new UserCreateDTO2());

        return "views/newUser2";
    }

    @PostMapping("/newUser2")
    public String newUserOk(
            @Valid @ModelAttribute("userDTO") UserCreateDTO2 user,
                BindingResult result, Model model) {
        log.info("전송된 사용자 정보 : {}", user);
        log.info("bindingResult : {}", result);

        if (result.hasErrors()) {
            // model.addAttribute("userDTO", user);

            return "views/newUser2";
        }

        return "views/newUserOk";
    }

}
