package com.letsdoit.todo.controllers;

import com.letsdoit.todo.Services.UserService;
import com.letsdoit.todo.dto.CreateUserDTo;
import com.letsdoit.todo.dto.UpdateUserDto;
import com.letsdoit.todo.dto.UserDto;
import com.letsdoit.todo.dto.UserResponseDto;
import com.letsdoit.todo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/users")
public class UserController {



    private final UserService userService;


    public  UserController(UserService userService){
        this.userService=userService;
    }


      @PostMapping
      public UserResponseDto createUser(@RequestBody CreateUserDTo dto){
        return  userService.createUser(dto);
      }

      @GetMapping("/all")
      public List<UserResponseDto> getAllUsers( ){
        return  userService.getAllUsers();
      }


      @PutMapping("/update/{id}")
    public  UserResponseDto updateUser(@PathVariable Long id , @RequestBody UpdateUserDto userDto){
        return  userService.updateUser(id,userDto);
      }

}
