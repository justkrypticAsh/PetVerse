package com.project.petverse.model;

/**
 * User Model
 * ---------------------------
 * Represents a user in the system.
 * Contains only data + getters/setters.
 * 
 * id        → Primary Key (auto increment)
 * name      → User's full name
 * email     → Unique email
 * password  → Hashed password (plain text not recommended)
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // ---- Getters & Setters ----

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
