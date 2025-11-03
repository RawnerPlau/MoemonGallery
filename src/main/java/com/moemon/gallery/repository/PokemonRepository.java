package com.moemon.gallery.repository;

import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.model.Sprite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByPokedexNoBetween(int start, int end);

    boolean existsByName(String name);
}
