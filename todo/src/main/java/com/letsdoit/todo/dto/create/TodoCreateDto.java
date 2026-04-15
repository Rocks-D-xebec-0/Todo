package com.letsdoit.todo.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;


public record TodoCreateDto(
        @NotBlank
        String title,

        String description,

        @NotNull
        ZonedDateTime startDate,

        @NotNull
        Long categoryId) {
}
