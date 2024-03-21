package org.baileyseye.author;
import org.baileyseye.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInserter {

    public static void insertAuthor(String authorName) {
        Connection connection = DatabaseConnector.connect();

        String insertSQL = "INSERT INTO shop.author (name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setString(1, authorName);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("A new author was inserted successfully.");
            } else {
                System.out.println("Inserting the new author failed.");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while inserting the new author. Error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close the connection. Error: " + e.getMessage());
                }
            }
        }
    }
}