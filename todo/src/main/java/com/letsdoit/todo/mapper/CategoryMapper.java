package com.letsdoit.todo.mapper;

import com.letsdoit.todo.dto.CategoryDto;
import com.letsdoit.todo.dto.create.CategoryCreateDto;
import com.letsdoit.todo.dto.reponse.CategoryResponseDto;
import com.letsdoit.todo.dto.update.CategoryUpdateDto;
import com.letsdoit.todo.model.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {


    private final TodoMapper toDoMapper;
    private final UserMapper userMapper;


    public CategoryMapper(TodoMapper todoMapper, UserMapper userMapper) {
        this.toDoMapper = todoMapper;
        this.userMapper = userMapper;
    }

    public Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        if (categoryDto.getUser() != null) {
            category.setUser(userMapper.toEntity(categoryDto.getUser()));
        }
        return category;
    }

    public Category toEntity(CategoryCreateDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public void updateEntity(Category category, CategoryUpdateDto categoryDto) {
        if (category == null || categoryDto == null) {
            return;
        }
        
        if (categoryDto.getName() != null) {
            category.setName(categoryDto.getName());
        }
        if (categoryDto.getDescription() != null) {
            category.setDescription(categoryDto.getDescription());
        }
    }

    public CategoryDto toDto(Category category) {
        if (category == null) {
            return null;
        }
        
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .user(category.getUser() != null ? userMapper.toDTO(category.getUser()) : null)
                .toDoList(
                        category.getTodoList() != null ?
                                category.getTodoList().stream()
                                .map(toDoMapper::toResponse)
                                .collect(Collectors.toList()) : null).build();
    }

    public CategoryResponseDto toResponse(Category category) {
        if (category == null) {
            return null;
        }
        
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .user(category.getUser() != null ? userMapper.toDTO(category.getUser()) : null)
                .toDoList(
                        category.getTodoList() != null ?
                                category.getTodoList().stream()
                                .map(toDoMapper::toResponse)
                                .collect(Collectors.toList()) : null).build();
    }
}

