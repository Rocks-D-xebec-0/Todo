package com.letsdoit.todo.mapper;


import com.letsdoit.todo.dto.create.UserCreateDto;
import com.letsdoit.todo.dto.update.UserUpdateDto;
import com.letsdoit.todo.dto.reponse.UserResponseDto;
import com.letsdoit.todo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserCreateDto dto) {
        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword()); // later hash it

        return user;
    }


    public static void updateEntity(User user, UserUpdateDto dto) {
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
