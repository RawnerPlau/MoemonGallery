package com.moemon.user.dto;

import java.util.Set;

public class UserDTO {
    private int id;
    private String username;
    private String name;
    private String description;
    private Set<LinkDTO> links;

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<LinkDTO> getLinks() {
        return links;
    }

    public void setLinks(Set<LinkDTO> links) {
        this.links = links;
    }
}
