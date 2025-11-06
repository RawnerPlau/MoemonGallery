package com.moemon.gallery.controller;

import com.moemon.gallery.dto.SpriteDTO;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.service.SpriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprites")
public class SpriteController {

    private final SpriteService spriteService;

    public SpriteController (SpriteService spriteService){
        this.spriteService = spriteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpriteDTO> getSprite (@PathVariable Long id){
        return ResponseEntity.ok(spriteService.findSpriteById(id));
    }
}
