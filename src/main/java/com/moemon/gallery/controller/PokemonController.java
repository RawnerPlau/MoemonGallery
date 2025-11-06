package com.moemon.gallery.controller;

import com.moemon.gallery.dto.PokemonDTO;
import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/search")
    public List<PokemonDTO> searchByName (@RequestParam String name){
        return pokemonService.searchByName(name);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String identifier) {
        Pokemon pokemon = pokemonService.getPokemonById(identifier);
        return ResponseEntity.ok(pokemon);
    }


}
