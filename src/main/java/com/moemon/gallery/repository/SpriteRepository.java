package com.moemon.gallery.repository;

import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.model.Sprite;
import com.moemon.gallery.model.SpriteCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpriteRepository extends JpaRepository<Sprite, Long> {
    List<Sprite> findByPokemon(Pokemon pokemon);

}
