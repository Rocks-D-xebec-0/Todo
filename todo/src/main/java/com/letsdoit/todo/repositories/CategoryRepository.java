package com.letsdoit.todo.repositories;


import com.letsdoit.todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {


    List<Category> findCategoriesByUserId(Long userId);






}
