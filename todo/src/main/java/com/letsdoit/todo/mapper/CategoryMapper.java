package com.letsdoit.todo.mapper;

import com.letsdoit.todo.dto.CategoryDto;
import com.letsdoit.todo.model.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {


    private final TodoMapper toDoMapper;


    public CategoryMapper(TodoMapper todoMapper) {
        this.toDoMapper = todoMapper;
    }

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

    public  CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .toDoList(
                        category.getTodoList() != null ?
                                category.getTodoList().stream()
                                .map(toDoMapper::toResponse)
                                .collect(Collectors.toList()) : null).build();
    }
}

