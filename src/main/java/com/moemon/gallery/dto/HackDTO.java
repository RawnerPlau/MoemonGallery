package com.moemon.gallery.dto;

import java.util.List;

public class HackDTO {
    private Integer id;
    private String name;
    private String description;
    private String developer;
    private Integer canvasSize;

    public HackDTO(Integer id, String name, String description, String developer, Integer canvasSize) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getCanvasSize() {
        return canvasSize;
    }

    public void setCanvasSize(Integer canvasSize) {
        this.canvasSize = canvasSize;
    }
}
