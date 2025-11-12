package com.moemon.gallery.service;

import com.moemon.gallery.dto.CreditDTO;
import com.moemon.gallery.dto.SpriteCreateDTO;
import com.moemon.gallery.dto.SpriteDTO;
import com.moemon.gallery.model.Credit;
import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.repository.SpriteRepository;
import com.moemon.user.model.User;
import com.moemon.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpriteService {

    private final SpriteRepository spriteRepository;
    private final UserRepository userRepository;

    public SpriteService(SpriteRepository spriteRepository, UserRepository userRepository){
        this.spriteRepository = spriteRepository;
        this.userRepository = userRepository;
    }

    public SpriteDTO findSpriteById (Long id){
        return toSpriteDTO(spriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprite is not found: " + id)));
    }

    public SpriteDTO addSprite (Pokemon pokemon, SpriteCreateDTO spriteDTO){
        Set<Credit> credits = new HashSet<>();
        for (CreditDTO creditDTO : spriteDTO.getCredits()){
            String username = creditDTO.getName();
            User user = userRepository.findByNameIgnoreCase(username)
                    .orElseThrow(() -> new RuntimeException("User not found with the name: " + username));
            Credit credit = new Credit(user, creditDTO.getCreditRole());
            credits.add(credit);
        }

        Sprite sprite = new Sprite(
                pokemon,
                spriteDTO.getFormName(),
                spriteDTO.getFormType(),
                spriteDTO.isEXForm(),
                spriteDTO.isShiny(),
                credits
                );
        Sprite newSprite = spriteRepository.save(sprite);
        return toSpriteDTO(newSprite);
    }

    public SpriteDTO toSpriteDTO (Sprite sprite){
        Set<CreditDTO> creditDTOS = new HashSet<>();
        for (Credit credit : sprite.getCredits()){
            CreditDTO creditDTO = new CreditDTO(credit.getUser().getName(), credit.getRole());
            creditDTOS.add(creditDTO);
        }
        return new SpriteDTO(
                sprite.getId(),
                sprite.getPokemon().getPokedexNo(),
                sprite.getPokemon().getName(),
                sprite.getFormName(),
                sprite.getFormType(),
                sprite.isEXForm(),
                sprite.isShiny(),
                sprite.getFileName(),
                creditDTOS
        );
    }
}
