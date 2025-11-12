package com.moemon.gallery.dto;

import com.moemon.gallery.model.Credit;
import com.moemon.gallery.model.FormType;

import java.util.Set;

public class SpriteDTO {
    private Integer id;
    private Integer pokedexNo;
    private String pokemonName;
    private String formName;
    private FormType formType;
    private boolean isEXForm;
    private boolean isShiny;
    private String fileName;
    private Set<CreditDTO> credits;

    public SpriteDTO(Integer id,
                     Integer pokedexNo,
                     String pokemonName,
                     String formName,
                     FormType formType,
                     boolean isEXForm,
                     boolean isShiny,
                     String fileName,
                     Set<CreditDTO> credits) {
        this.id = id;
        this.pokedexNo = pokedexNo;
        this.pokemonName = pokemonName;
        this.formName = formName;
        this.formType = formType;
        this.isEXForm = isEXForm;
        this.isShiny = isShiny;
        this.fileName = fileName;
        this.credits = credits;
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

    public Set<CreditDTO> getCredits() {
        return credits;
    }

    public void setCredits(Set<CreditDTO> credits) {
        this.credits = credits;
    }
}
