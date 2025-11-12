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
import java.util.stream.Collectors;

@Service
public class SpriteService {

    private final SpriteRepository spriteRepository;
    private final UserRepository userRepository;

    public SpriteService(SpriteRepository spriteRepository, UserRepository userRepository){
        this.spriteRepository = spriteRepository;
        this.userRepository = userRepository;
    }

    public Sprite findSpriteById(Long id){
        return spriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprite is not found: " + id));
    }

    public SpriteDTO findSpriteDTOById(Long id){
        return new SpriteDTO(findSpriteById(id));
    }

    public SpriteDTO addSprite (Pokemon pokemon, SpriteCreateDTO spriteDTO){
        Sprite sprite = new Sprite(
                pokemon,
                spriteDTO.getFormName(),
                spriteDTO.getFormType(),
                spriteDTO.isEXForm(),
                spriteDTO.isShiny()
                );
        Set<Credit> credits = CreditDTOsToCredits(spriteDTO.getCredits(), sprite);
        sprite.setCredits(credits);
        Sprite newSprite = spriteRepository.save(sprite);
        return new SpriteDTO(newSprite);
    }

    public SpriteDTO updateCredits (Long spriteId, Set<CreditDTO> creditDTOS){
        Sprite sprite = spriteRepository.findById(spriteId)
                .orElseThrow(() -> new RuntimeException("Sprite not found by Id: " + spriteId));
        Set<Credit> existingCredits = sprite.getCredits();
        Set<Credit> newCredits = CreditDTOsToCredits(creditDTOS, sprite);

        existingCredits.removeIf(credit -> !newCredits.contains(credit));
        existingCredits.addAll(newCredits);
        spriteRepository.save(sprite);
        return new SpriteDTO(sprite);
    }

    private Set<Credit> CreditDTOsToCredits(Set<CreditDTO> creditDTOS, Sprite sprite){
        if (creditDTOS == null) return new HashSet<>();
        return creditDTOS.stream()
                .map(dto -> {
                    Credit credit = new Credit();
                    credit.setSprite(sprite);
                    credit.setUser(userRepository.findByNameIgnoreCase(dto.getName())
                            .orElseThrow(() -> new RuntimeException("User not found with the name: " + dto.getName())));
                    credit.setRole(dto.getCreditRole());
                    return credit;
                })
                .collect(Collectors.toSet());
    }
}
