package com.letsdoit.todo.controllers;


import com.letsdoit.todo.Services.TodoService;
import com.letsdoit.todo.dto.create.TodoCreateDto;
import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.update.TodoUpdateDto;
import com.letsdoit.todo.exceptions.BadRequestException;
import com.letsdoit.todo.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    private final TodoService service;

    public TodoController(TodoService todoService) {
        this.service = todoService;
    }


    @PostMapping("/create")
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoCreateDto todoDto) {
        if (todoDto == null) {
            throw new BadRequestException("Todo data cannot be null");
        }
        TodoResponse response = service.createTodo(todoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TodoResponse> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody TodoUpdateDto todoUpdateDto) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid todo ID: ID must be a positive number");
        }
        if (todoUpdateDto == null) {
            throw new BadRequestException("Update data cannot be null");
        }
        TodoResponse response = service.update(todoUpdateDto, id);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/all")
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<TodoResponse> todos = service.finAll();
        return ResponseEntity.ok(todos);
    }


    @DeleteMapping("/hard/{id}")
    public ResponseEntity<Map<String, String>> deleteTodo(@PathVariable Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid todo ID: ID must be a positive number");
        }
        service.hardDelete(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo permanently deleted");
        response.put("todoId", id.toString());
        return ResponseEntity.ok(response);
    }


}
