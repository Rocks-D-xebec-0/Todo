package com.letsdoit.todo.dto;

import com.letsdoit.todo.mapper.UserMapper;
import com.letsdoit.todo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private CreateUserDTo user;

    private List<TodoDto> toDoList;


    public static Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());


        if (categoryDto.getUser() != null) {
            category.setUser(UserMapper.toEntity(categoryDto.getUser()));
        }
        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .toDoList(
                        category.getTodoList() != null ? category.getTodoList().stream().map(TodoDto::fromEntity)
                                                         .collect(Collectors.toList()) : null).build();


    }
}
