package com.moemon.gallery.dto;

public class PokemonDTO {
    private int pokedexNo;
    private String name;

    public PokemonDTO() {
    }

    public PokemonDTO(int pokedexNo, String name) {
        this.pokedexNo = pokedexNo;
        this.name = name;
    }

    public int getPokedexNo() {
        return pokedexNo;
    }

    public void setPokedexNo(int pokedexNo) {
        this.pokedexNo = pokedexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
