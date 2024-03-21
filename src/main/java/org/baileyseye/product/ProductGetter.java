package org.baileyseye.product;

import org.baileyseye.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductGetter {

    private static final String QUERY = "SELECT product_name, product_price FROM shop.product";

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                products.add(new Product(name, price));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching products. Error: " + e.getMessage());
        }

        return products;
    }
}