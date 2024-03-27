package org.baileyseye;

import org.baileyseye.product.Product;
import org.baileyseye.product.ProductGetter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getProducts();
    }

    private static void getProducts() {
        ProductGetter productGetter = new ProductGetter();
        List<Product> products = productGetter.getProducts();
        if (products != null && !products.isEmpty()) {
            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("No products found.");
        }
    }
}