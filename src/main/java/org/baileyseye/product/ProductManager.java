package org.baileyseye.product;

import org.baileyseye.database.DatabaseConnector;
import org.baileyseye.database.SQLQueries;
import org.baileyseye.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductManager {

    public static void insertProduct(String productName, int productPrice) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Создание нативного SQL запроса для вставки продукта
            String sql = SQLQueries.INSERT_PRODUCT;
            int affectedRows = session.createNativeQuery(sql)
                    .setParameter(1, productName)
                    .setParameter(2, productPrice)
                    .executeUpdate();

            if (affectedRows > 0) {
                System.out.println("A new product was inserted successfully.");
            } else {
                System.out.println("Inserting the new product failed.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error occurred while inserting the new product. Error: " + e.getMessage());
        }
    }
}


