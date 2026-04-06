package com.letsdoit.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {



    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;


    @OneToMany(mappedBy = "category",fetch =FetchType.EAGER)
    private List<Todo> todoList;

}
