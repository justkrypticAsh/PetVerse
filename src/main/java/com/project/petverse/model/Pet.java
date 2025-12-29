package com.project.petverse.model;

/**
 * Pet Model
 * ---------------------------
 * Represents a pet in the adoption platform.
 *
 * adopted  → false by default
 */
public class Pet {

    private int id;
    private String name;
    private int age;
    private String type;      // Dog, Cat, Bird
    private String breed;
    private String description;
    private String imageUrl;
    private boolean adopted;

    public Pet() {}

    public Pet(String name, int age, String type, String breed, String description, String imageUrl) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.breed = breed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.adopted = false;
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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAdopted() {
        return adopted;
    }
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
}
