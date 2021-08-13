package com.test.security.controller;

import com.test.security.model.ToDo;
import com.test.security.model.User;
import com.test.security.service.ToDoService;
import com.test.security.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Data
public class MainController {

    private final UserService userService;

    private final ToDoService toDoService;

    private final ModelMapper mapper= new ModelMapper();

    @GetMapping
    public String showMainPage(Principal principal, Model model, Pageable pageable){
        if (principal!=null){
            User user = userService.getUser(principal.getName());
            Page<ToDo> ToDos = toDoService.getAllToDosByUser(user,pageable);
            model.addAttribute("user",user);
            model.addAttribute("todos",
                    ToDos.stream()
                            .map(p -> mapper.map(p, ToDo.class))
                                .collect(Collectors.toList()));
            return "index";
        };

        return "index";
    }

}
