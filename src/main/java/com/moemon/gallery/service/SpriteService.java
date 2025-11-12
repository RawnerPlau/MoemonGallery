package com.moemon.gallery.service;

import com.moemon.gallery.dto.SpriteCreateDTO;
import com.moemon.gallery.dto.SpriteDTO;
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

    public SpriteDTO findSpriteById (Long id){
        return toSpriteDTO(spriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprite is not found: " + id)));
    }

    public SpriteDTO addSprite (Pokemon pokemon, SpriteCreateDTO spriteDTO){
        Sprite sprite = new Sprite(
                pokemon,
                spriteDTO.getFormName(),
                spriteDTO.getFormType(),
                spriteDTO.isEXForm(),
                spriteDTO.isShiny());
        Sprite newSprite = spriteRepository.save(sprite);
        return toSpriteDTO(newSprite);
    }

    public SpriteDTO toSpriteDTO (Sprite sprite){
        return new SpriteDTO(
                sprite.getId(),
                sprite.getPokemon().getPokedexNo(),
                sprite.getPokemon().getName(),
                sprite.getFormName(),
                sprite.getFormType(),
                sprite.isEXForm(),
                sprite.isShiny(),
                sprite.getFileName()
        );
    }
}
