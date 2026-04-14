package com.letsdoit.todo.Services;


import com.letsdoit.todo.dto.TodoDto;
import com.letsdoit.todo.mapper.TodoMapper;
import com.letsdoit.todo.repositories.CategoryRepository;
import com.letsdoit.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {


    @Autowired
    private TodoRepository todoRepository;




    public TodoDto save(TodoDto todoDto){

        var todo = TodoMapper.toEntity(todoDto);
        var saved =todoRepository.save(todo);

        return  TodoMapper.fromEntity(saved);
    }

    public List<TodoDto> finAll(){
        return  todoRepository.findAll().stream()
                .map(TodoMapper::fromEntity)
                .collect(Collectors.toList()) ;

    }



    public  void delete(Long id ){
        if ( id ==null)
        {
            return;
        }
        todoRepository.deleteById(id);
        
    }




}
