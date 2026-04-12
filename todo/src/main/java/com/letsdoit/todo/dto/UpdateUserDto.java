package com.letsdoit.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
}
