package com.project.petverse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.petverse.model.Pet;
import com.project.petverse.util.DBConnection;

public class PetDAO {

    /**
     * Add New Pet
     */
    public boolean addPet(Pet pet) {
        String query = "INSERT INTO pets(name, age, type, breed, description, image_url, status) "
                     + "VALUES (?, ?, ?, ?, ?, ?, 'Available')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getType());
            stmt.setString(4, pet.getBreed());
            stmt.setString(5, pet.getDescription());
            stmt.setString(6, pet.getImageUrl());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get All Available Pets
     */
    public List<Pet> getAllPets() {
        List<Pet> list = new ArrayList<>();
        String query = "SELECT * FROM pets WHERE status='Available'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                pet.setType(rs.getString("type"));
                pet.setBreed(rs.getString("breed"));
                pet.setDescription(rs.getString("description"));
                pet.setImageUrl(rs.getString("image_url"));
                pet.setAdopted(false); // since no adopted column

                list.add(pet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Get Single Pet by ID
     */
    public Pet getPetById(int id) {
        String query = "SELECT * FROM pets WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                pet.setType(rs.getString("type"));
                pet.setBreed(rs.getString("breed"));
                pet.setDescription(rs.getString("description"));
                pet.setImageUrl(rs.getString("image_url"));
                pet.setAdopted(false);
                return pet;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update Pet
     */
    public boolean updatePet(Pet pet) {
        String query = "UPDATE pets SET name=?, age=?, type=?, breed=?, description=?, image_url=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getType());
            stmt.setString(4, pet.getBreed());
            stmt.setString(5, pet.getDescription());
            stmt.setString(6, pet.getImageUrl());
            stmt.setInt(7, pet.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete Pet
     */
    public boolean deletePet(int id) {
        String query = "DELETE FROM pets WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Adopt Pet → Set status to Adopted
     */
    public boolean adoptPet(int id) {
        String query = "UPDATE pets SET status='Adopted' WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
