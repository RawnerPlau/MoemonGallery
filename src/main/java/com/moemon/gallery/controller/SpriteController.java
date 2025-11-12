package com.moemon.gallery.controller;

import com.moemon.gallery.dto.CreditDTO;
import com.moemon.gallery.dto.SpriteDTO;
import com.moemon.gallery.service.SpriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sprites")
public class SpriteController {

    private final SpriteService spriteService;

    public SpriteController (SpriteService spriteService){
        this.spriteService = spriteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpriteDTO> getSprite (@PathVariable Long id){
        return ResponseEntity.ok(spriteService.findSpriteDTOById(id));
    }

    @PostMapping("/{id}/credits")
    public ResponseEntity<SpriteDTO> updateCredits(@PathVariable Long id, @RequestBody Set<CreditDTO> credits){
        return ResponseEntity.ok(spriteService.updateCredits(id, credits));
    }

    @GetMapping("/{id}/credits")
    public ResponseEntity<Set<CreditDTO>> getCredits (@PathVariable Long id){
        return ResponseEntity.ok(spriteService.getSpriteCreditsDTO(id));
    }
}
