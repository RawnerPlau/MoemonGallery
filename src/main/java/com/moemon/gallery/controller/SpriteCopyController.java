package com.moemon.gallery.controller;

import com.moemon.gallery.dto.SpriteCopyCreateDTO;
import com.moemon.gallery.dto.SpriteCopyDTO;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.service.HackService;
import com.moemon.gallery.service.SpriteCopyService;
import com.moemon.gallery.service.SpriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hack-sprites")
public class SpriteCopyController {

    private final SpriteCopyService spriteCopyService;
    public SpriteCopyController (SpriteCopyService spriteCopyService){
        this.spriteCopyService = spriteCopyService;
    }

    @PostMapping("/{spriteId}")
    public ResponseEntity<SpriteCopyDTO> addSpriteToHack (@PathVariable Long spriteId, @RequestBody SpriteCopyCreateDTO copyDTO){
        return ResponseEntity.ok(spriteCopyService.addSpriteToHack(spriteId, copyDTO));
    }
}
