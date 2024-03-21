package org.baileyseye;

import java.sql.Connection;
import java.sql.SQLException;

import static org.baileyseye.CategoryInserter.insertCategory;

public class Main {
    public static void main(String[] args) {
        connected();
    }

    private static void connected() {
        DatabaseConnector.loadPostgresDriver();
        Connection connection = DatabaseConnector.connect();
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection to the database is closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}