package com.letsdoit.todo.dto.update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserUpdateDto {

    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;
    
    @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;
    
    @Email(message = "Email should be valid")
    private String email;
    
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String userName;
}
