package org.baileyseye.product;

import org.baileyseye.product.Product;
import org.baileyseye.database.SQLQueries;
import org.baileyseye.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductGetter {

    public List<Product> getProducts() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Product> products = null;
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery(SQLQueries.GET_PRODUCTS, Product.class);
            products = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Error occurred while fetching products. Error: " + e.getMessage());
        } finally {
            entityManager.close();
        }

        return products;
    }
}