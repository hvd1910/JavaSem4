package com.example.apfast.model;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Members {
    @Column(name = "user_id")
    @Id
    private String userId;

    private String password;
    private boolean isActive;

    // Getters and setters...

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
