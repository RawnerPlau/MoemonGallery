package com.moemon.gallery.service;

import com.moemon.gallery.dto.SpriteCopyCreateDTO;
import com.moemon.gallery.dto.SpriteCopyDTO;
import com.moemon.gallery.model.Hack;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.model.SpriteCopy;
import com.moemon.gallery.repository.HackRepository;
import com.moemon.gallery.repository.SpriteCopyRepository;
import com.moemon.gallery.repository.SpriteRepository;
import org.springframework.stereotype.Service;

@Service
public class SpriteCopyService {

    private final SpriteCopyRepository spriteCopyRepository;
    private final SpriteRepository spriteRepository;
    private final HackRepository hackRepository;

    public SpriteCopyService (SpriteCopyRepository spriteCopyRepository,
                              SpriteRepository spriteRepository,
                              HackRepository hackRepository){
        this.spriteCopyRepository = spriteCopyRepository;
        this.spriteRepository = spriteRepository;
        this.hackRepository = hackRepository;
    }

    public SpriteCopyDTO addSpriteToHack(Long spriteId, SpriteCopyCreateDTO spriteCopyCreateDTO){
        Sprite sprite = spriteRepository.findById(spriteId)
                .orElseThrow(() -> new RuntimeException("Sprite not found"));
        Hack hack = hackRepository.findByNameIgnoreCase(spriteCopyCreateDTO.getHack())
                .orElseThrow(() -> new RuntimeException("Hack not found."));
        SpriteCopy spriteCopy = new SpriteCopy(sprite, hack, spriteCopyCreateDTO.getStatus(), spriteCopyCreateDTO.isPriority());
        SpriteCopy savedCopy = spriteCopyRepository.save(spriteCopy);
        return toSpriteCopyDTO(savedCopy);
    }

    public SpriteCopyDTO toSpriteCopyDTO (SpriteCopy spriteCopy){
        return  new SpriteCopyDTO(
                spriteCopy.getId(),
                spriteCopy.getSprite().getPokemon().getName(),
                spriteCopy.getSprite().getPokemon().getPokedexNo(),
                spriteCopy.getHack().getName(),
                spriteCopy.getSprite().getFileName(),
                spriteCopy.getStatus(),
                spriteCopy.isPriority()
        );
    }
}
