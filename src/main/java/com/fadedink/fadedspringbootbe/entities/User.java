package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable=false, unique = true)
    public String username;
    @Column(nullable=false)
    public String password;
    @Column(nullable=false)
    public String email;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
