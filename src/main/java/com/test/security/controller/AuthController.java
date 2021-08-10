package com.test.security.controller;

import com.test.security.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String signIn() {
        return "login";
    }


    @GetMapping("/register")
    public String signUpPage(Model model) {
        if (!model.containsAttribute("user")){
            model.addAttribute("user",new User());
        }
        return "register";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute("user") User user) {

//        userService.signUpUser(user);

        return "redirect:/auth/login";
    }



}
