package com.letsdoit.todo.dto;


import com.letsdoit.todo.mapper.CategoryMapper;
import com.letsdoit.todo.model.Todo;
import com.letsdoit.todo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TodoDto {


    private Long id;

    private String title;

    private String description;

    private ZonedDateTime startDate;

    private boolean done;

    private boolean favourite;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoryDto category;

}