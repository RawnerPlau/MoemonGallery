package com.moemon.gallery.model;

import com.moemon.gallery.dto.Credit;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dex_entries")
public class DexEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String text;

    @OneToMany(mappedBy = "dexEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpriteCopy> spriteCopies = new HashSet<>();

    @OneToMany(mappedBy = "dexEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Credit> credits = new HashSet<>();

    public DexEntry() {
    }

    public DexEntry(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public void addCredit(Credit credit){
        credits.add(credit);
        credit.setDexEntry(this);
    }

    public void removeCredit(Credit credit){
        credits.remove(credit);
        credit.setDexEntry(null);
    }
}
