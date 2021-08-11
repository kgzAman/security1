package com.test.security.controller;

import com.test.security.model.User;
import com.test.security.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;


@Controller
@RequestMapping("/admin")
@Data
public class AdminController {

    private final UserService userService;

    private final ModelMapper mapper= new ModelMapper();

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String showAllFunction(){
        return "admin";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/admin/getAllUsers";
    }

    @PostMapping("/getUser")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String getUserByEMail(@RequestParam String email, Model model){
        User user = userService.getUser(email);
        model.addAttribute("user",user);
        return "userInfo";
    }

    @PostMapping("/ban/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String makeBannedUser(@PathVariable Long id, Model model){
        User user = userService.makeStatusBan(id);
        model.addAttribute("user",user);
        return "userInfo";
    }
    @PostMapping("/active/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String makeActiveUser(@PathVariable Long id, Model model){
        User user = userService.makeStatusActive(id);
        model.addAttribute("user",user);
        return "userInfo";
    }

    @GetMapping("/getAllUsers")
    public String showAllUsers(Model model, Pageable pageable){
        Page<User> users = userService.getAllUsers(pageable);
        model.addAttribute("users",users.stream()
                        .map(p -> mapper.map(p, User.class))
                        .collect(Collectors.toList()));
        model.addAttribute("page",users.getPageable());
        return "users";
    }
}
