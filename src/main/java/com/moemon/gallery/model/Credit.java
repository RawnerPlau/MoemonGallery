package com.moemon.gallery.model;

import com.moemon.user.model.User;
import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals  (Object o){
        if (this == o) return true; // same object
        if (!(o instanceof Credit credit)) return false; // wrong type
        boolean sameSprite = sprite != null && sprite.equals(credit.getSprite());
        boolean sameDex = dexEntry != null && dexEntry.equals(credit.getDexEntry());

        boolean sameParent = sameSprite || sameDex;

        return sameParent &&
                Objects.equals(user, credit.getUser()) &&
                Objects.equals(role, credit.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role, sprite != null ? sprite : dexEntry);
    }
}
