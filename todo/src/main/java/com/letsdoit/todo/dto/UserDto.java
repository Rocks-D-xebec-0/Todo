package com.letsdoit.todo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsdoit.todo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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




public  User toEntity(UserDto userDto){


    User user=new User();

    user.setId(userDto.getId());
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setUserName(userDto.getUserName());
    user.setPassword(userDto.getPassword());
    return user;
}



public  UserDto fromEntity(User user){
    UserDto userDto=new UserDto();

    userDto.setId(user.getId());
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setEmail(user.getEmail());
    userDto.setUserName(user.getUserName());
    return userDto;


}




}
