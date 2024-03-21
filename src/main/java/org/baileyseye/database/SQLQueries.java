package org.baileyseye.database;

public class SQLQueries {
    public static final String INSERT_PRODUCT =
            "INSERT INTO shop.product(product_name, product_price) VALUES (?, ?)";
    public static final String GET_PRODUCTS =
            "SELECT product_name, product_price FROM shop.product";
    public static final String DELETE_PRODUCT_BY_NAME =
            "DELETE FROM shop.product WHERE product_name = ?";
    public static final String INSERT_AUTHOR =
            "INSERT INTO shop.author (name) VALUES (?)";
    public static final String RETRIEVE_AUTHORS_BY_CATEGORY_NAME =
            "SELECT a.* FROM shop.author a INNER JOIN shop.categories c ON a.categories = " +
                    "c.categories_id WHERE c.categories_name = ?";
    public static final String INSERT_CATEGORY =
            "INSERT INTO shop.categories (categories_name) VALUES (?)";
}
