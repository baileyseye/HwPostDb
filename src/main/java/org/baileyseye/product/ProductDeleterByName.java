package org.baileyseye.product;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleterByName {

    public static void deleteProductByName(String productName) {
        Connection connection = DatabaseConnector.connect();


        try (PreparedStatement preparedStatement = connection.prepareStatement
                (SQLQueries.DELETE_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, productName);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the given name.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting the product. Error: " + e.getMessage());
        }
    }
}