package com.moemon.gallery.service;

import com.moemon.gallery.dto.PokemonDTO;
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

    public List<PokemonDTO> searchByName(String name) {
        return pokemonRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(p -> new PokemonDTO(p.getPokedexNo(), p.getName()))
                .toList();
    }

    public Pokemon getPokemonById(String identifier) {
        try {
            // Try parsing as a number first (ID)
            Long id = Long.parseLong(identifier);
            return pokemonRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pokemon not found with ID: " + id));
        } catch (NumberFormatException e) {
            // Not a number → treat as name
            return pokemonRepository.findByNameIgnoreCase(identifier)
                    .orElseThrow(() -> new RuntimeException("Pokemon not found with name: " + identifier));
        }
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
