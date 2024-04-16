package com.mugesh.realestate.model;

import jakarta.persistence.*;



@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private User user;

    public UserProfile(Long id, String address, User user) {
        this.id = id;
        this.address = address;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // Constructors, getters, and setters
}