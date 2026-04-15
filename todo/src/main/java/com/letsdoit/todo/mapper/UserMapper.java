package com.letsdoit.todo.mapper;


import com.letsdoit.todo.dto.create.UserCreateDto;
import com.letsdoit.todo.dto.update.UserUpdateDto;
import com.letsdoit.todo.dto.reponse.UserResponseDto;
import com.letsdoit.todo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateDto dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        // TODO: Hash password before storing - use BCryptPasswordEncoder
        user.setPassword(dto.getPassword());

        return user;
    }

    public User toEntity(UserResponseDto dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());

        return user;
    }

    public void updateEntity(User user, UserUpdateDto dto) {
        if (user == null || dto == null) {
            return;
        }
        
        if (dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
        if (dto.getUserName() != null) {
            user.setUserName(dto.getUserName());
        }
    }


    public UserResponseDto toDTO(User user) {
        if (user == null) {
            return null;
        }
        
        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());

        return dto;
    }

}
