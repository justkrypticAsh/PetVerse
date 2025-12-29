package com.project.petverse.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBConnection Utility Class
 * ----------------------------------------------------------
 * This class provides a single method getConnection()
 * which returns a JDBC connection to the MySQL database.
 *
 * Make sure your MySQL database is running and the credentials
 * (URL, USERNAME, PASSWORD) match your local setup.
 *
 * URL structure:
 *   jdbc:mysql://HOST:PORT/DATABASE_NAME
 *
 * Common issues:
 *  - MySQL not running
 *  - Wrong username/password
 *  - Wrong JDBC driver version
 * ----------------------------------------------------------
 */
public class DBConnection {

   
   private static final String URL =
    "jdbc:mysql://localhost:3306/petverse_db?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&serverTimezone=UTC";


    private static final String USERNAME = "root";      
    private static final String PASSWORD = "Lko567u";   

    /**
     * Returns a new database connection.
     * 
     * @return Connection object or null if connection fails.
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Load JDBC driver (automatically done in newer versions, but safe to include)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try connecting to DB
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {

            // Print full error in console for debugging
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
        }

        return conn;
    }
}
