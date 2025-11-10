package com.moemon.gallery.controller;

import com.moemon.gallery.dto.HackCreateDTO;
import com.moemon.gallery.dto.HackDTO;
import com.moemon.gallery.service.HackService;
import com.moemon.user.model.User;
import com.moemon.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hack")
public class HackController {
    private HackService hackService;
    private UserService userService;

    public HackController (HackService hackService, UserService userService){
        this.hackService = hackService;
        this.userService = userService;
    }

    @PostMapping("/add_hack")
    public ResponseEntity<HackDTO> addHack (@RequestBody HackCreateDTO hackCreateDTO){
        User developer = userService.findUserByName(hackCreateDTO.getDeveloperName());
        return ResponseEntity.ok(hackService.addHack(hackCreateDTO, developer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HackDTO> getHack (@PathVariable Long id){
        return ResponseEntity.ok(hackService.getHack(id));
    }
}
