package com.moemon.user.model;

import com.moemon.gallery.model.DexEntry;
import com.moemon.gallery.model.Sprite;
import jakarta.persistence.*;

@Entity
@Table(name = "credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "sprite_id")
    private Sprite sprite;

    @ManyToOne
    @JoinColumn(name = "dex_entry_id")
    private DexEntry dexEntry;

    @Enumerated(EnumType.STRING)
    private CreditRole role;

    public Credit() {
    }

    public Credit(User user, CreditRole role) {
        this.user = user;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public DexEntry getDexEntry() {
        return dexEntry;
    }

    public void setDexEntry(DexEntry dexEntry) {
        this.dexEntry = dexEntry;
    }

    public CreditRole getRole() {
        return role;
    }

    public void setRole(CreditRole role) {
        this.role = role;
    }
}
