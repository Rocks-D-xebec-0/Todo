package com.letsdoit.todo.Services;


import com.letsdoit.todo.dto.create.TodoCreateDto;
import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.update.TodoUpdateDto;
import com.letsdoit.todo.exceptions.BadRequestException;
import com.letsdoit.todo.exceptions.ResourceNotFoundException;
import com.letsdoit.todo.mapper.TodoMapper;
import com.letsdoit.todo.model.Todo;
import com.letsdoit.todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {



    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;


    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    public TodoResponse createTodo(TodoCreateDto todoCreateDto) {
        if (todoCreateDto == null) {
            throw new BadRequestException("Todo data cannot be null");
        }
        
        Todo todo = todoMapper.toEntity(todoCreateDto);
        Todo savedTodo = todoRepository.save(todo);

        return todoMapper.toResponse(savedTodo);
    }



    public TodoResponse update(TodoUpdateDto todoDto, Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid todo ID: ID must be a positive number");
        }
        
        if (todoDto == null) {
            throw new BadRequestException("Update data cannot be null");
        }
        
        var todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        
        todoMapper.updateEntity(todo, todoDto);
        todoRepository.save(todo);
        
        return todoMapper.toResponse(todo);
    }

    public List<TodoResponse> finAll() {
        return todoRepository.findAll().stream()
                .map(todoMapper::toResponse)
                .collect(Collectors.toList());

    }



    public void hardDelete(Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid todo ID: ID must be a positive number");
        }
        
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        
        todoRepository.delete(todo);
    }
}
