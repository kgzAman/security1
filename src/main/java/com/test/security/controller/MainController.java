package com.test.security.controller;

import com.test.security.model.User;
import com.test.security.repository.UserRepository;
import com.test.security.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("home")
@Data
public class MainController {


    private final UserService userService;

    @GetMapping
    public String showMainPage(Principal principal, Model model){
        if (principal!=null){
            User user = userService.getUser(principal.getName());
            model.addAttribute("user",user);
            return "index";
        };

        return "index";
    }
}
