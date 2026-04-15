package com.letsdoit.todo.controllers;


import com.letsdoit.todo.Services.TodoService;
import com.letsdoit.todo.dto.create.TodoCreateDto;
import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.update.TodoUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    private final TodoService service;

    public  TodoController(TodoService todoService){
        this.service=todoService;
    }


    @PostMapping("/create")
    public TodoResponse createTodo(@RequestBody TodoCreateDto todoDto){
        return service.createTodo(todoDto);
    }


    @PutMapping("/update/{id}")
    public TodoResponse updateTodo(@PathVariable TodoUpdateDto todoUpdateDto ,@PathVariable Long id ){
        return service.update(todoUpdateDto,id);
    }



    @GetMapping("/all")
    public List<TodoResponse> getAllTodos(){
        return service.finAll();
    }


    @DeleteMapping("/hard/{id}")
    public void deleteTodo(@PathVariable Long id ){
        service.delete(id);
    }


}
