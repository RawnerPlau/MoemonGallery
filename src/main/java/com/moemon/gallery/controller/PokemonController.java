package com.moemon.gallery.controller;

import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    // ✅ Constructor injection (best practice)
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }


    @GetMapping("/{identifier}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String identifier) {
        Pokemon pokemon = pokemonService.getPokemonById(identifier);
        return ResponseEntity.ok(pokemon);
    }


}
