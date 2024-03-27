package org.baileyseye.product;

import org.baileyseye.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ProductGetter {

    public List<Product> getProducts() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        List products = null;
        try {
            entityManager = JpaUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

                Query query = entityManager.createQuery
                        ("SELECT p FROM Product p", Product.class);
                products = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error occurred while fetching products. Error: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return products;
    }
}
