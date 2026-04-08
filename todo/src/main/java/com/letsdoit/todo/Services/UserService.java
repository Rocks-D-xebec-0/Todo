package com.letsdoit.todo.Services;

import com.letsdoit.todo.dto.CreateUserDTo;
import com.letsdoit.todo.dto.UpdateUserDto;
import com.letsdoit.todo.dto.UserResponseDto;
import com.letsdoit.todo.exceptions.BadRequestException;
import com.letsdoit.todo.exceptions.ResourceNotFoundException;
import com.letsdoit.todo.mapper.UserMapper;
import com.letsdoit.todo.model.User;
import com.letsdoit.todo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(CreateUserDTo userDto) {
        if (userDto == null) {
            throw new BadRequestException("User data cannot be null");
        }
        
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public UserResponseDto updateUser(Long id, UpdateUserDto userDto) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid user ID: ID must be a positive number");
        }
        
        if (userDto == null) {
            throw new BadRequestException("Update data cannot be null");
        }
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

        userMapper.updateEntity(user, userDto);
        userRepository.save(user);
        return userMapper.toDTO(user);
    }

}
