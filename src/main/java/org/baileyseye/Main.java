package org.baileyseye;

import org.baileyseye.product.Product;
import org.baileyseye.product.ProductGetter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        AuthorRetriever.retrieveAuthorsByCategoryName();
       AuthorInserter.insertAuthor("Joker");
        ProductDeleterByName.deleteProductByName("master and margarita");
        ProductManager.insertProduct("Aston", 100500);
        */
        getProducts();
    }

    private static void getProducts() {
        ProductGetter productGetter = new ProductGetter();
        List<Product> products = productGetter.getProducts();
        for (Product product : products) {
            System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }
}