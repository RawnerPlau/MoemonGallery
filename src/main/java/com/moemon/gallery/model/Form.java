package com.moemon.gallery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "sprite_id")
    private Sprite sprite;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private FormType type;

    @Column(name = "is_exclusive")
    private boolean isExclusive;

    public Form() {
    }

    public Form(Sprite sprite, String name, FormType type, boolean isExclusive) {
        this.sprite = sprite;
        this.name = name;
        this.type = type;
        this.isExclusive = isExclusive;
    }

    public Integer getId() {
        return id;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FormType getType() {
        return type;
    }

    public void setType(FormType type) {
        this.type = type;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }


}
