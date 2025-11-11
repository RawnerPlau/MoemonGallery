package com.moemon.gallery.dto;

import com.moemon.gallery.model.Status;

public class SpriteCopyCreateDTO {
    private Integer spriteId;
    private String hack;
    private Status status;
    private boolean isPriority;

    public SpriteCopyCreateDTO() {
    }

    public SpriteCopyCreateDTO(Integer spriteId, String hack, Status status, boolean isPriority) {
        this.spriteId = spriteId;
        this.hack = hack;
        this.status = status;
        this.isPriority = isPriority;
    }

    public Integer getSpriteId() {
        return spriteId;
    }

    public void setSpriteId(Integer spriteId) {
        this.spriteId = spriteId;
    }

    public String getHack() {
        return hack;
    }

    public void setHack(String hack) {
        this.hack = hack;
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
}
