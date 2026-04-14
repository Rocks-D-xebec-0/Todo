package com.letsdoit.todo.mapper;


import com.letsdoit.todo.dto.TodoDto;
import com.letsdoit.todo.model.Todo;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class TodoMapper {



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
