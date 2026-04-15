package com.letsdoit.todo.dto;

import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.reponse.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private UserResponseDto user;

    private List<TodoResponse> toDoList;
}
