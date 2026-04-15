package com.letsdoit.todo.dto.reponse;

import java.time.ZonedDateTime;

public record TodoResponse(
        Long id,
        String title,
        String description,
        ZonedDateTime startDate,
        boolean done,
        boolean favourite,
        Long categoryId,
        String categoryName
) {
}
