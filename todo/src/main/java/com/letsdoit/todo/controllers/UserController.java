package com.letsdoit.todo.controllers;

import com.letsdoit.todo.Services.UserService;
import com.letsdoit.todo.dto.ApiResponseDto;
import com.letsdoit.todo.dto.CreateUserDTo;
import com.letsdoit.todo.dto.UpdateUserDto;
import com.letsdoit.todo.dto.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserDTo dto) {
        UserResponseDto response = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserDto userDto) {
        UserResponseDto response = userService.updateUser(id, userDto);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/{id}")
    public  ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id ){
        UserResponseDto response=userService.getUserById(id);
        return  ResponseEntity.ok(response);
    }




@DeleteMapping("hard/{id}")
    public ResponseEntity<Map<String,String>> hardDelete(@PathVariable Long id ){

        userService.hardDelete(id);

        Map<String,String > response=new HashMap<>();
        response.put("message","user permanently deleted");
        response.put("userId","User permanently deleted");
        

}


}
