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


}
