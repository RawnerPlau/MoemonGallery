package com.moemon.gallery.model;

import com.moemon.gallery.converter.BooleanToYesNoConverter;
import com.moemon.user.model.Credit;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "sprite_copies")
public class SpriteCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hack_id")
    private Hack hack;

    @ManyToOne
    @JoinColumn(name = "sprite_id")
    private Sprite sprite;

    @ManyToOne
    @JoinColumn(name = "dex_entry_id")
    private DexEntry dexEntry;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "is_priority")
    @Convert(converter = BooleanToYesNoConverter.class)
    private boolean isPriority;

    public SpriteCopy() {
    }

    public SpriteCopy(Sprite sprite, Hack hack, Status status, boolean isPriority) {
        this.sprite = sprite;
        this.hack = hack;
        this.status = status;
        this.isPriority = isPriority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hack getHack() {
        return hack;
    }

    public void setHack(Hack hack) {
        this.hack = hack;
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

    public void removeHack(){
        hack.removeSpriteCopy(this);
    }
}
