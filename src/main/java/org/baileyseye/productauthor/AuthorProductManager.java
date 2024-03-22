package org.baileyseye.productauthor;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorProductManager {

    public static void insertRelation(int authorId, int productId) {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (SQLQueries.INSERT_INTO_AUTHOR_PRODUCT)) {

            preparedStatement.setInt(1, authorId);
            preparedStatement.setInt(2, productId);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Relation between author and product was inserted successfully.");
            } else {
                System.out.println("Inserting relation failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting the relation. Error: " + e.getMessage());
        }
    }

    public static void getAllRelations() {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (SQLQueries.SELECT_FROM_AUTHOR_PRODUCT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int authorNameId = resultSet.getInt("author_name_id");
                int authorProductId = resultSet.getInt("author_product_id");
                System.out.println("Author ID: " + authorNameId + ", Product ID: " + authorProductId);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching the relations. Error: " + e.getMessage());
        }
    }
}
