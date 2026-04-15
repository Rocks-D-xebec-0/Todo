package com.letsdoit.todo.repositories;

import com.letsdoit.todo.dto.reponse.TodoResponse;
import com.letsdoit.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {


    List<TodoResponse> findTodoByCategoryId(Long categoryId);

}
