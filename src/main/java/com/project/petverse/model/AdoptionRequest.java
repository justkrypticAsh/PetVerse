package com.project.petverse.model;

import java.sql.Timestamp;

public class AdoptionRequest {

    private int id;
    private int petId;
    private int userId;
    private Timestamp adoptedAt;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getAdoptedAt() {
        return adoptedAt;
    }
    public void setAdoptedAt(Timestamp adoptedAt) {
        this.adoptedAt = adoptedAt;
    }
}
