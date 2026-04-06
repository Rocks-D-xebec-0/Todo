package com.letsdoit.todo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsdoit.todo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {



    private Long id ;
    private String firstName;
    private String lastName ;
    private String email ;
    private String userName ;
    private String password;

    @JsonIgnore
    private List<CategoryDto> category;


    public static User toEntity(UserDto userDto){
        final User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCategory(userDto.getCategory() !=null ? userDto.getCategory().stream().map(CategoryDto::toEntity).collect(Collectors.toList()) : null);

;
return user;
    }

    public static UserDto



}
