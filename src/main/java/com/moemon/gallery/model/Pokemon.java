package com.moemon.gallery.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "pokedex_no")
    private Integer pokedexNo;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Generation generation;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sprite> sprites = new ArrayList<>();

    public Pokemon() {
    }

    public Pokemon(Integer pokedexNo, String name) {
        this.pokedexNo = pokedexNo;
        this.name = name;
        this.generation = Generation.fromPokedexNumber(pokedexNo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexNo() {
        return pokedexNo;
    }

    public void setPokedexNo(Integer pokedexNo) {
        this.pokedexNo = pokedexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
        sprite.setPokemon(this);
    }

    public void removeSprite(Sprite sprite){
        sprites.remove(sprite);
        sprite.setPokemon(null);
    }
}
