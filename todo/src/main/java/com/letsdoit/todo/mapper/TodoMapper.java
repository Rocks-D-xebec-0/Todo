package com.letsdoit.todo.mapper;


import com.letsdoit.todo.dto.create.TodoCreateDto;
import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.update.TodoUpdateDto;
import com.letsdoit.todo.model.Todo;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class TodoMapper {



    public Todo toEntity(TodoCreateDto todoDto) {
        if (todoDto == null) {
            return null;
        }
        
        final Todo todo = new Todo();
        todo.setTitle(todoDto.title());
        todo.setDescription(todoDto.description());
        todo.setDone(false);
        todo.setFavorite(false);
        todo.setStartDate(
                todoDto.startDate() != null
                        ? todoDto.startDate()
                        : ZonedDateTime.now()
        );

        return todo;
    }

    public TodoResponse toResponse(Todo todo) {
        if (todo == null) {
            return null;
        }
        
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStartDate(),
                todo.isDone(),
                todo.isFavorite(),
                todo.getCategory() != null ? todo.getCategory().getId() : null,
                todo.getCategory() != null ? todo.getCategory().getName() : null

        );
    }


    public void updateEntity(Todo todo , TodoUpdateDto todoUpdateDto){
        if (todo == null || todoUpdateDto == null) {
            return;
        }

        if (todoUpdateDto.title() != null) {
            todo.setTitle(todoUpdateDto.title());
        }
        if (todoUpdateDto.description() != null) {
            todo.setDescription(todoUpdateDto.description());
        }
        todo.setDone(todoUpdateDto.done());
        todo.setFavorite(todoUpdateDto.favourite());
    }

}
