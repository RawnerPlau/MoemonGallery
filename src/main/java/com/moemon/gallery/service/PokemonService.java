package com.moemon.gallery.service;

import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    // 🔍 Business logic methods
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    @Transactional
    public Pokemon createPokemon(Pokemon pokemon) {
        // Business validation example
        if (pokemonRepository.existsByName(pokemon.getName())) {
            throw new IllegalArgumentException("Pokemon already exists!");
        }

        // Modify before saving
        pokemon.setName(pokemon.getName().trim());
        return pokemonRepository.save(pokemon);
    }

    @Transactional
    public void deletePokemon(Long id) {
        if (!pokemonRepository.existsById(id)) {
            throw new RuntimeException("Pokemon not found");
        }
        pokemonRepository.deleteById(id);
    }
}
