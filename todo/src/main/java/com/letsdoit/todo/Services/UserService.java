package com.letsdoit.todo.Services;

import com.letsdoit.todo.dto.create.UserCreateDto;
import com.letsdoit.todo.dto.update.UserUpdateDto;
import com.letsdoit.todo.dto.reponse.UserResponseDto;
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

    public UserResponseDto createUser(UserCreateDto userDto) {
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

    public UserResponseDto updateUser(Long id, UserUpdateDto userDto) {
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

    public  UserResponseDto getUserById(Long id ){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

    return  userMapper.toDTO(user);
    }

    public void hardDelete(Long id ){
        User user =userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));




        userRepository.delete(user);
    }

    public void softDeleteUser(Long id ){
        User user=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with "+id));

        user.setIs_deleted(true);
        userRepository.save(user);

    }

    public void restoreUser(Long id ){
        User user= userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id "+id));

        if  (!user.getIs_deleted()){
            throw  new IllegalStateException("Uer is not deleted ");
        }

        user.setIs_deleted(false);
        user.setDeletedAt(null);
        userRepository.save(user);

    }

}
