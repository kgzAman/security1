package com.test.security.model;

import com.test.security.enums.ToDoStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
@Table(name = "to_do")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ToDoStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
}
