package com.moemon.user.model;
import java.util.HashSet;
import java.util.Set;

import com.moemon.gallery.model.Credit;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column
    private String description;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SocialLink> links = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Credit> credits;

    @Column(name = "icon_path")
    private String iconPath;

    public User() {
    }

    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SocialLink> getLinks() {
        return links;
    }

    public void setLinks(Set<SocialLink> links) {
        this.links = links;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    private void addRole(Role role){
        roles.add(role);
        role.getUsers().add(this);
    }

    private void removeRole(Role role){
        roles.remove(role);
        role.getUsers().remove(this);
    }

    private void addLink(SocialLink link){
        links.add(link);
        link.setUser(this);
    }
}
