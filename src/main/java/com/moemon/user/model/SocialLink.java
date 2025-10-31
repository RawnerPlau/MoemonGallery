package com.moemon.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "social_links")
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "platform", nullable = false)
    private String socialPlatform;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SocialLink() {
    }

    public SocialLink(String socialPlatform, String url) {
        this.socialPlatform = socialPlatform;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSocialPlatform() {
        return socialPlatform;
    }

    public void setSocialPlatform(String socialPlatform) {
        this.socialPlatform = socialPlatform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
