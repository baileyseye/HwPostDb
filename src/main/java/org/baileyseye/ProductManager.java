package org.baileyseye;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductManager {

    public static void insertProduct(String productName, int productPrice, int categoryId) {
        Connection connection = DatabaseConnector.connect();

        String insertSQL = "INSERT INTO shop.product(product_name, product_price, categories) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productPrice);
            preparedStatement.setInt(3, categoryId);

            int affectedRows = preparedStatement.executeUpdate();

            if ( affectedRows >  0){
                System.out.println("A new product was inserted successfully.");
            } else{
                System.out.println("Inserting the new product failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting the new product. Error: " + e.getMessage());
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

