package com.moemon.gallery.controller;

import com.moemon.gallery.dto.PokemonDTO;
import com.moemon.gallery.dto.SpriteCreateDTO;
import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.service.PokemonService;
import com.moemon.gallery.service.SpriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    private  final SpriteService spriteService;

    public PokemonController(PokemonService pokemonService, SpriteService spriteService) {
        this.pokemonService = pokemonService;
        this.spriteService = spriteService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/search")
    public List<PokemonDTO> searchByName (@RequestParam String name){
        return pokemonService.searchByName(name);
    }

    @PostMapping("/{identifier}/new_sprite")
    public ResponseEntity<SpriteCreateDTO> addSprite(
            @PathVariable String identifier,
            @RequestBody SpriteCreateDTO spriteDTO) {
        Pokemon pokemon = pokemonService.findPokemonByIdOrName(identifier);
        return ResponseEntity.ok(spriteService.addSprite(pokemon, spriteDTO));
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String identifier) {
        Pokemon pokemon = pokemonService.findPokemonByIdOrName(identifier);
        return ResponseEntity.ok(pokemon);
    }


}
