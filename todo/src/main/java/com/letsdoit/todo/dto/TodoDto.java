package com.letsdoit.todo.dto;


import com.letsdoit.todo.mapper.CategoryMapper;
import com.letsdoit.todo.model.Todo;
import com.letsdoit.todo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TodoDto {


    private Long id;

    private String title;

    private String description;

    private ZonedDateTime startDate;

    private boolean done;

    private boolean favourite;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoryDto category;

    public static Todo toEntity(TodoDto todoDto) {
        final Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDone(todoDto.isDone());
        todo.setFavorite(todoDto.isFavourite());
        todo.setStartDate(
                todoDto.getStartDate() !=  null
                ? todoDto.getStartDate()
                        : ZonedDateTime.now()
        );

        if (todoDto.getCategory() !=null ){
            todo.setCategory(CategoryMapper.toEntity(todoDto.getCategory()));

        }

        return todo;
    }

    public static TodoDto fromEntity(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .startDate(todo.getStartDate())
                .done(todo.isDone())
                .favourite(todo.isFavorite())
                .build();
    }
}