package com.letsdoit.todo.dto.update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserUpdateDto {


     @NotBlank ( message = "First name is required")
     @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;
     @NotBlank (message = "Last name is required")
     @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;
     @Email(message = "Email should be valid")
     @NotBlank (message = "Email is required")
    private String email;
     @NotBlank
     @Size(message = "Username must be between 3 and 20 characters", min = 3, max = 20)
    private String userName;
}
