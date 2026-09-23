package com.example.restapi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.domain.UserCreateDTO;
import com.example.restapi.service.UserService;
import com.example.restapi.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController3 {

    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/getUsers")
    public String getUsers(Model model) {
        log.info("getUsers 호출!!");

        ArrayList<FindAllUserDTO> users = userService.readAllUser();
        model.addAttribute("users", users);

        return "views/listUser";
    }

		@GetMapping({"/getUser/{userid}", "/getUser"})
    public String getUser(@PathVariable Optional<String> userid, Model model) {

        User user = userService.readByUserid(userid.orElse("abc123"));
        model.addAttribute("user", user);

        return "views/getUser";
    }

    @GetMapping("/newUser")
    public String newUser() {

        return "views/newUser";
    }

    @PostMapping("/newUser")
    public String newUserOk(UserCreateDTO user, Model model) {
        log.info("전송된 사용자 정보 : {}", user);

        if (userServiceImpl.newUser(user)) {
            model.addAttribute("user", user);
            model.addAttribute("msg", "사용자 등록 성공!!");
        } else {
            model.addAttribute("msg", "사용자 등록 실패!!");
        }

        return "views/newUserOk";
    }

}