package org.baileyseye;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleterByName {

    public static void deleteProductByName(String productName) {
        Connection connection = DatabaseConnector.connect();
        String deleteSQL = "DELETE FROM shop.product WHERE product_name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
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