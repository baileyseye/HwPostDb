package org.baileyseye;

import java.sql.Connection;
import java.sql.SQLException;

import static org.baileyseye.CategoryInserter.insertCategory;
import static org.baileyseye.ProductManager.insertProduct;

public class Main {
    public static void main(String[] args) {
        /*
        AuthorRetriever.retrieveAuthorsByCategoryName();
       AuthorInserter.insertAuthor("John Doe");
        ProductDeleterByName.deleteProductByName("master and margarita");
        */

        ProductManager.insertProduct("kekwer2", 500, 1);
    }
}