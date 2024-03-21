package org.baileyseye.author;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRetriever {

    public static void retrieveAuthorsByCategoryName() {

        Connection connection = DatabaseConnector.connect();

        try (PreparedStatement preparedStatement = connection.prepareStatement
                (SQLQueries.RETRIEVE_AUTHORS_BY_CATEGORY_NAME)) {
            preparedStatement.setString(1, "Authors");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Предположим, что у вас есть столбцы id и name в таблице author
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("Author ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving authors. Error: " + e.getMessage());
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