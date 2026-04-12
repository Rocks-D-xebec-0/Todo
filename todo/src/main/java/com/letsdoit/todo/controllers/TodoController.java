package com.letsdoit.todo.controllers;


import com.letsdoit.todo.Services.TodoService;
import com.letsdoit.todo.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService service;



    @PostMapping("/create")
    public TodoDto createTodo(@RequestBody TodoDto todoDto){
        return service.save(todoDto);
    }


    @PutMapping("/update/{id}")
    public TodoDto updateTodo(@PathVariable TodoDto todoDto){
        return service.save(todoDto);
    }



    @GetMapping("/all")
    public List<TodoDto> getAllTodos(Long todoId){
        return service.finAll();
    }


    @DeleteMapping("/hard/{id}")
    public void deleteTodo(@PathVariable Long id ){
        service.delete(id);
    }


}
