package com.moemon.gallery.model;

import com.moemon.user.model.Credit;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sprites")
public class Sprite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "form_type")
    @Enumerated(EnumType.STRING)
    private FormType formType;

    @Column(name = "is_EXForm")
    private boolean isEXForm;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(mappedBy = "sprite", cascade = CascadeType.MERGE)
    private Set<SpriteCopy> spriteCopies = new HashSet<>();

    @OneToMany(mappedBy = "sprite", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Credit> credits = new HashSet<>();

    @Column(name = "is_shiny")
    private boolean isShiny;

    public Sprite() {
    }

    public Sprite(Pokemon pokemon, String formName, FormType formType, boolean isEXForm, boolean isShiny) {
        this.pokemon = pokemon;
        this.formName = formName;
        this.formType = formType;
        this.isEXForm = isEXForm;
        this.isShiny = isShiny;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<SpriteCopy> getSpriteCopies() {
        return spriteCopies;
    }

    public void setSpriteCopies(Set<SpriteCopy> spriteCopies) {
        this.spriteCopies = spriteCopies;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public void addSpriteCopy(SpriteCopy spriteCopy){
        spriteCopies.add(spriteCopy);
        spriteCopy.setSprite(this);
    }

    public void removeSpriteCopy(SpriteCopy spriteCopy){
        spriteCopies.remove(spriteCopy);
        spriteCopy.setSprite(null);
    }

    public void addCredit(Credit credit){
        credits.add(credit);

    }

    @PostPersist
    private void onPersist() {
        if (fileName == null || fileName.isEmpty()) {
            if(!isShiny){
                this.fileName = String.format("%04d_%04d_%s.png", pokemon.getPokedexNo(), id, pokemon.getName());
            } else {
                this.fileName = String.format("%04d_%04d_%s_Shiny.png", pokemon.getPokedexNo(), id, pokemon.getName());
            }
        }
    }
}
