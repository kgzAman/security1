package com.test.security.service;

import com.test.security.dto.ToDoDto;
import com.test.security.enums.ToDoStatus;
import com.test.security.exeptions.NotFoundException;
import com.test.security.model.ToDo;
import com.test.security.model.User;
import com.test.security.repository.ToDoRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;


@Service
@Data
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserService userService;

    public Page<ToDo> getAllToDosByUser(User user, Pageable pageable) {
        return  toDoRepository.findByAuthor(user, pageable);
    }

    public void creatNewToDo(ToDoDto toDoDto, Principal principal) {
        User user = userService.getUser(principal.getName());
        ToDo toDo= new ToDo();
        toDo.setAuthor(user);
        toDo.setCreatedDate(LocalDate.now());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setHeader(toDoDto.getHeader());
        toDo.setStatus(ToDoStatus.NEW);
        toDoRepository.save(toDo);
    }

    public ToDo getByID(Long id) {
       return toDoRepository.findById(id).orElseThrow(()-> new NotFoundException("ToDo Not Founded"));
    }

    public void startToDO(Long id ) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new NotFoundException("ToDo Not Founded"));
        toDo.setStatus(ToDoStatus.ON_POSSES);
        toDoRepository.save(toDo);
    }

    public void upDate(ToDoDto toDoDto, Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new NotFoundException("ToDo Not Founded"));
        if (!toDoDto.getDescription().isEmpty()){
            toDo.setDescription(toDoDto.getDescription());
        }
        if(!toDoDto.getHeader().isEmpty()){
            toDo.setHeader(toDoDto.getHeader());
        }
        toDoRepository.save(toDo);
    }

    public void delete(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new NotFoundException("ToDo Not Founded"));
        toDoRepository.delete(toDo);
    }

    public void doneToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new NotFoundException("ToDo Not Founded"));
        toDo.setStatus(ToDoStatus.DONE);
        toDoRepository.save(toDo);
    }
}
