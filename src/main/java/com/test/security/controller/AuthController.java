package com.test.security.controller;

import com.test.security.dto.UserDto;
import com.test.security.model.User;
import com.test.security.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@Data
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String signIn() {
        return "login";
    }


    @GetMapping("/register")
    public String signUpPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute("user") UserDto userDto) {
        userService.creatUser(userDto);
        return "redirect:/auth/login";
    }



}
