package com.project.petverse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.petverse.model.User;
import com.project.petverse.util.DBConnection;

/**
 * UserDAO
 * ---------------------------------------------------------
 * Handles all user-related database operations:
 *  - register user
 *  - login user
 *  - check if email already exists
 *
 * Uses DBConnection.getConnection() to connect to MySQL.
 * ---------------------------------------------------------
 */
public class UserDAO {

    /**
     * Registers a new user.
     * @param user - User object with name, email, password
     * @return true if successful, false otherwise
     */
    public boolean registerUser(User user) {
        String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Checks if email already exists.
     * @param email - user email
     * @return true if exists, false if not
     */
    public boolean emailExists(String email) {
        String query = "SELECT id FROM users WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // returns true if email found

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }


    /**
     * Login user with email + password
     * @return User object if login successful, else null
     */
    public User loginUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
