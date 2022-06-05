package com.example.project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "User ID is required")
    private Integer userid;
    @NotNull(message = "Book ID is required")
    private Integer bookid;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;

    public Loan(Object o, Integer id, Integer id1) {
    }
}
