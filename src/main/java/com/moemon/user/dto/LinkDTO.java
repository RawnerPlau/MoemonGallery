package com.moemon.user.dto;

public class LinkDTO {
    private String platform;
    private String link;

    public LinkDTO() {
    }

    public LinkDTO(String platform, String link) {
        this.platform = platform;
        this.link = link;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
