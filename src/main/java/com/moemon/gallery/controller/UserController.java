package com.moemon.gallery.controller;

import com.moemon.user.service.UserService;
import com.moemon.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody UserDTO user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
