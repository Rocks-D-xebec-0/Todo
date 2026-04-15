package com.letsdoit.todo.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoFullUpdateDTo(
        @NotBlank(message = "Title is required")
        @Size(max = 255)
        String title,

        @Size(max = 1000)
        String description,

        boolean done,
        boolean favourite
) {

}
