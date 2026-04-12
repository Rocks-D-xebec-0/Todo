package com.letsdoit.todo.mapper;


import com.letsdoit.todo.dto.CreateUserDTo;
import com.letsdoit.todo.dto.UpdateUserDto;
import com.letsdoit.todo.dto.UserResponseDto;
import com.letsdoit.todo.model.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(CreateUserDTo dto) {
        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword()); // later hash it

        return user;
    }


    public static void updateEntity(User user, UpdateUserDto dto) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
    }


    public UserResponseDto toDTO(User user) {
        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());

        return dto;
    }



}
