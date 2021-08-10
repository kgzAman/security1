package com.test.security.controller;

import com.test.security.service.UserService;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Data
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public String showAllFunction(){
        return "admin";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
