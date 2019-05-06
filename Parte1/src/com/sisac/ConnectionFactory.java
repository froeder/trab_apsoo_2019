package com.sisac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public ConnectionFactory() {

    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:hsqldb:file:sisac/", "SA", "");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
