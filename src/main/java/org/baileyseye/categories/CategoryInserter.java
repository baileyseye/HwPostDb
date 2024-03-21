package org.baileyseye.categories;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryInserter {

    public static void insertCategory(String categoryName) {
        Connection connection = DatabaseConnector.connect();

        try (PreparedStatement preparedStatement = connection.prepareStatement
                (SQLQueries.INSERT_CATEGORY)) {

            preparedStatement.setString(1, categoryName);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("A new category was inserted successfully.");
            } else {
                System.out.println("Inserting the new category failed.");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while inserting the new category. Error: " + e.getMessage());
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
