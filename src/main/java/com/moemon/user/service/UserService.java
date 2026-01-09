package com.moemon.user.service;

import com.moemon.user.dto.UserDTO;
import com.moemon.user.mapper.UserMapper;
import com.moemon.user.model.User;
import com.moemon.user.dto.CreateUserDTO;
import com.moemon.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(CreateUserDTO createUserDTO){
        User user = new User(createUserDTO.getUsername(), createUserDTO.getName(), createUserDTO.getPassword());
        userRepository.save(user);
    }

    public User findUserByName(String name){
        return userRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findUserDTOById(Long id){
        return UserMapper.toDTO(findUserById(id));
    }

    public CreateUserDTO toDTO(User user){
        return new CreateUserDTO(
                user.getUsername(),
                user.getName(),
                user.getPassword()
        );
    }
}
