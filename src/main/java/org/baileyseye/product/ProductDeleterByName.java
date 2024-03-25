package org.baileyseye.product;

import jakarta.persistence.Query;
import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;
import org.baileyseye.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleterByName {

    public static void deleteProductByName(String productName) {
        Connection connection = DatabaseConnector.connect();


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createNativeQuery(SQLQueries.DELETE_PRODUCT_BY_NAME);
            query.setParameter("productName", productName);
            int affectedRows = query.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the given name.");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error occurred while deleting the product. Error: " + e.getMessage());
        }
}
}