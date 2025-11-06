package com.moemon.gallery.dto;

import com.moemon.gallery.model.FormType;
import lombok.Builder;
import lombok.Data;

public class SpriteDTO {
    private Integer id;
    private Integer pokedexNo;
    private String pokemonName;
    private String formName;
    private FormType formType;
    private boolean isEXForm;
    private boolean isShiny;
    private String fileName;

    public SpriteDTO(Integer id,
                     Integer pokedexNo,
                     String pokemonName,
                     String formName,
                     FormType formType,
                     boolean isEXForm,
                     boolean isShiny,
                     String fileName) {
        this.id = id;
        this.pokedexNo = pokedexNo;
        this.pokemonName = pokemonName;
        this.formName = formName;
        this.formType = formType;
        this.isEXForm = isEXForm;
        this.isShiny = isShiny;
        this.fileName = fileName;
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

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public boolean isEXForm() {
        return isEXForm;
    }

    public void setEXForm(boolean EXForm) {
        isEXForm = EXForm;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
