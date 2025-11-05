package com.moemon.user.service;

import com.moemon.user.model.User;
import com.moemon.user.model.UserDTO;
import com.moemon.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(UserDTO userDTO){
        User user = new User(userDTO.getUsername(), userDTO.getName(), userDTO.getPassword());
        userRepository.save(user);
    }
}
