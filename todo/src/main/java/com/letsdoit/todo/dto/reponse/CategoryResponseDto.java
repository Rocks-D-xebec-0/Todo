package com.letsdoit.todo.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryResponseDto {

    private Long id;

    private String name;

    private String description;

    private UserResponseDto user;

    private List<TodoResponse> toDoList;
}

