package com.example.project3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required") @Column(unique = true)
    private String name;
    @NotEmpty(message = "Type is required")
    private String genre;

    @ManyToMany(mappedBy = "books",cascade = CascadeType.ALL)
    private Set<Loan> loans;
}
