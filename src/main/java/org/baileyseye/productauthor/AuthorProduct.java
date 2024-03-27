package org.baileyseye.productauthor;

import jakarta.persistence.*;
import org.baileyseye.author.Author;
import org.baileyseye.product.Product;

@Entity
@Table(name = "author_product", schema = "shop")
public class AuthorProduct {
    @EmbeddedId
    private AuthorProductId id;

    @MapsId("authorNameId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_name_id", nullable = false)
    private Author authorName;

    @MapsId("authorProductId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_product_id", nullable = false)
    private Product authorProduct;

    public AuthorProductId getId() {
        return id;
    }

    public void setId(AuthorProductId id) {
        this.id = id;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    public Product getAuthorProduct() {
        return authorProduct;
    }

    public void setAuthorProduct(Product authorProduct) {
        this.authorProduct = authorProduct;
    }

}