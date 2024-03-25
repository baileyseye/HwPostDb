package org.baileyseye.product;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;
import org.baileyseye.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductGetter {



    public List<Product> getProducts() {
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createNativeQuery(SQLQueries.GET_PRODUCTS);
            products = query.list();
        } catch (Exception e) {
            System.out.println("Error occurred while fetching products. Error: " + e.getMessage());
        }

        return products;
    }
}