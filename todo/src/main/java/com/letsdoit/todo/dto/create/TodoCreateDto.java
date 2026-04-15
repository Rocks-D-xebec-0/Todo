package com.letsdoit.todo.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.ZonedDateTime;


public record TodoCreateDto(
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title must be less than 255 characters")
        String title,

        @Size(max = 1000, message = "Description must be less than 1000 characters")
        String description,

        @NotNull(message = "Start date is required")
        ZonedDateTime startDate,

        @NotNull(message = "Category ID is required")
        Long categoryId) {
}
