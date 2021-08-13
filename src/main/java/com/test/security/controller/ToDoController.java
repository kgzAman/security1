package com.test.security.controller;

import com.test.security.dto.ToDoDto;
import com.test.security.model.ToDo;
import com.test.security.service.ToDoService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/toDo")
@Data
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/{id}")
    public String displayToDo(@PathVariable Long id, Model model){
        ToDo toDo = toDoService.getByID(id);
        model.addAttribute(toDo);
        return "todo";
    }

    @GetMapping("/creat")
    public String creatToDo(){
        return "creatToDo";
    }

    @PostMapping("/creat")
    public String creatToDo(@ModelAttribute (name="todo")ToDoDto toDoDto, Principal principal){
        toDoService.creatNewToDo(toDoDto, principal);
        return "redirect:/";
    }

    @PostMapping("/start/{id}")
    public String getStarted(@PathVariable Long id){
        toDoService.startToDO(id);
        return "redirect:/toDo/{id}";
    }

    @PostMapping("/update/{id}")
    public String upDateToDO(@ModelAttribute (name="todo")ToDoDto toDoDto,@PathVariable Long id ){
        toDoService.upDate(toDoDto, id);
        return "redirect:/toDo/{id}";
    }

    @PostMapping("/done/{id}")
    public String finishJob(@PathVariable Long id){
        toDoService.doneToDo(id);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        toDoService.delete(id);
        return "redirect:/";
    }




}
