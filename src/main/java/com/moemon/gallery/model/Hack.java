package com.moemon.gallery.model;

import com.moemon.user.model.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "hacks")
public class Hack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @OneToMany(mappedBy = "hack", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpriteCopy> spriteCopies = new ArrayList<>();

    @Column(name = "canvas_size")
    private Integer canvasSize;

    public Hack() {
    }

    public Hack(String name, User developer, Integer canvasSize) {
        this.name = name;
        this.developer = developer;
        this.canvasSize = canvasSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public List<SpriteCopy> getSpriteCopies() {
        return spriteCopies;
    }

    public void setSpriteCopies(List<SpriteCopy> spriteCopies) {
        this.spriteCopies = spriteCopies;
    }

    public Integer getCanvasSize() {
        return canvasSize;
    }

    public void setCanvasSize(Integer canvasSize) {
        this.canvasSize = canvasSize;
    }

    public void addSpriteCopy(SpriteCopy spriteCopy){
        spriteCopies.add(spriteCopy);
        spriteCopy.setHack(this);
    }

    public void removeSpriteCopy(SpriteCopy spriteCopy){
        spriteCopies.remove(spriteCopy);
        spriteCopy.setHack(null);
    }
}
