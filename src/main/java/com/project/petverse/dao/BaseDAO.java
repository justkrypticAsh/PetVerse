package com.project.petverse.dao;

import com.project.petverse.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
}
