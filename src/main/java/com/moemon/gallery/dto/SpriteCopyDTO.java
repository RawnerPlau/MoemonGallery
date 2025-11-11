package com.moemon.gallery.dto;

import com.moemon.gallery.model.Status;

public class SpriteCopyDTO {
    private Integer id;
    private String pokemon;
    private Integer pokedexNo;
    private String hack;
    private String fileName;
    private Status status;
    private boolean isPriority;

    public SpriteCopyDTO() {
    }

    public SpriteCopyDTO(Integer id,
                         String pokemon,
                         Integer pokedexNo,
                         String hack,
                         String fileName,
                         Status status,
                         boolean isPriority) {
        this.id = id;
        this.pokemon = pokemon;
        this.pokedexNo = pokedexNo;
        this.hack = hack;
        this.fileName = fileName;
        this.status = status;
        this.isPriority = isPriority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public Integer getPokedexNo() {
        return pokedexNo;
    }

    public void setPokedexNo(Integer pokedexNo) {
        this.pokedexNo = pokedexNo;
    }

    public String getHack() {
        return hack;
    }

    public void setHack(String hack) {
        this.hack = hack;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }
}
