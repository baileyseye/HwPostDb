package org.baileyseye;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/testdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection connect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL database successfully.");
        } catch (SQLException e) {
            System.out.println("Connection to the PostgreSQL database failed. Error: " + e.getMessage());
        }
        return connection;
    }

    public static void loadPostgresDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load PostgreSQL JDBC Driver. Error: " + e.getMessage());
        }
    }

}