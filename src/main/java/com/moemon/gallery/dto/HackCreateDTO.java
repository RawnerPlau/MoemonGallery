package com.moemon.gallery.dto;

public class HackCreateDTO {
    public String name;
    public String description;
    public String developerName;
    public Integer canvasSize;

    public HackCreateDTO() {
    }

    public HackCreateDTO(String name,String description, String developerName, Integer canvasSize) {
        this.name = name;
        this.description = description;
        this.developerName = developerName;
        this.canvasSize = canvasSize;
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

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getCanvasSize() {
        return canvasSize;
    }

    public void setCanvasSize(Integer canvasSize) {
        this.canvasSize = canvasSize;
    }
}
