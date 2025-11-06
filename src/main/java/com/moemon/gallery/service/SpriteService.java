package com.moemon.gallery.service;

import com.moemon.gallery.dto.SpriteCreateDTO;
import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.repository.PokemonRepository;
import com.moemon.gallery.repository.SpriteRepository;
import org.springframework.stereotype.Service;

@Service
public class SpriteService {

    private final SpriteRepository spriteRepository;

    public SpriteService(SpriteRepository spriteRepository, PokemonRepository pokemonRepository){
        this.spriteRepository = spriteRepository;
    }

    public SpriteCreateDTO addSprite (Pokemon pokemon, SpriteCreateDTO spriteDTO){
        Sprite sprite = new Sprite(
                pokemon,
                spriteDTO.getFormName(),
                spriteDTO.getFormType(),
                spriteDTO.isEXForm(),
                spriteDTO.isShiny());
        Sprite newSprite = spriteRepository.save(sprite);
        return new SpriteCreateDTO(
                newSprite.getId(),
                newSprite.getFormName(),
                newSprite.getFormType(),
                newSprite.isEXForm(),
                newSprite.isShiny()
        );
    }
}
