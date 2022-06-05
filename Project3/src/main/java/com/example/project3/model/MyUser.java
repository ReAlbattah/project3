package com.example.project3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username is required") @Column(unique = true)
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;


}
