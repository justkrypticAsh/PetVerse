package com.project.petverse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.petverse.util.DBConnection;

public class AdoptionRequestDAO {

    // Insert adoption
    public boolean createRequest(int petId, int userId) {
        String sql = "INSERT INTO adoption_requests (pet_id, user_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            stmt.setInt(2, userId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if the pet is already adopted
    public boolean isPetAdopted(int petId) {
        String sql = "SELECT id FROM adoption_requests WHERE pet_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // if exists → adopted

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if THIS USER has adopted THIS PET
    public boolean isAdoptedByUser(int petId, int userId) {
        String sql = "SELECT id FROM adoption_requests WHERE pet_id = ? AND user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            stmt.setInt(2, userId);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
