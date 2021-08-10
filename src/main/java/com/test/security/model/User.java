package com.test.security.model;


import com.test.security.enums.Role;
import com.test.security.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @NotBlank
    @Column(name = "sur_name")
    private String surName;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "email")
    @Email
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "roles")
    @Builder.Default
    private Role userRole=Role.ROLE_USER;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private Status status = Status.ACTIVE ;

    public User() {
    }

//    public User(Long id, @NotBlank String userName, String surName,
//                String password, @Email String email, String userRole, Status status) {
//        this.id = id;
//        this.userName = userName;
//        this.surName = surName;
//        this.password = password;
//        this.email = email;
//        this.userRole = userRole;
//        this.status = status;
//    }

}