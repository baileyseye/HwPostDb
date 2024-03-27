package org.baileyseye.categories;

import jakarta.persistence.*;
import org.baileyseye.author.Author;
import org.baileyseye.product.Product;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categories", schema = "shop")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id", nullable = false)
    private Integer id;

    @Column(name = "categories_name", nullable = false, length = 100)
    private String categoriesName;

    @OneToMany(mappedBy = "categories")
    private Set<Author> authors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "categories")
    private Set<Product> products = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}