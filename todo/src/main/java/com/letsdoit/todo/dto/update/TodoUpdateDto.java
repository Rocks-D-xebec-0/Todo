package com.letsdoit.todo.dto.update;


import jakarta.validation.constraints.Size;


public record TodoUpdateDto(

        @Size(max = 255, message = "Title must be less than 255 characters")
        String title,
        @Size(max = 1000, message = "Description must be less than 1000 characters")

        String description,
        boolean done ,
        boolean favourite
) {

}
