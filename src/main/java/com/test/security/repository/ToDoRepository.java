package com.test.security.repository;

import com.test.security.model.ToDo;
import com.test.security.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    Page<ToDo> findByAuthor(User user, Pageable page);
    Optional<ToDo>findByAuthor(User user);
    Optional<ToDo> findById(Long id);
}
