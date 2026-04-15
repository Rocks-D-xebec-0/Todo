package com.letsdoit.todo.Services;


import com.letsdoit.todo.dto.create.TodoCreateDto;
import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.dto.update.TodoUpdateDto;
import com.letsdoit.todo.mapper.TodoMapper;
import com.letsdoit.todo.model.Todo;
import com.letsdoit.todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {



    private final  TodoRepository todoRepository;
    private final   TodoMapper todoMapper;


    public  TodoService(TodoRepository todoRepository,TodoMapper todoMapper){
        this.todoRepository=todoRepository;
        this.todoMapper=todoMapper;
    }

public   TodoResponse createTodo(TodoCreateDto todoCreateDto){
    Todo todo=todoMapper.toEntity(todoCreateDto);
    Todo savedTodo=todoRepository.save(todo);

    return todoMapper.toResponse(savedTodo);
}



    public TodoResponse update(TodoUpdateDto todoDto,Long id){
        var todo = todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found with id: " + id));
        return  todoMapper.toResponse(todo) ;
    }

    public List<TodoResponse> finAll(){
        return  todoRepository.findAll().stream()
                .map(todoMapper::toResponse)
                .collect(Collectors.toList()) ;

    }



    public  void hardDelete(Long id ){
        if ( id ==null)
        {
            return;
        }
        todoRepository.deleteById(id);
        
    }





}
