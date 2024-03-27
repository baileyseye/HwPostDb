package org.baileyseye.author;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuthorProductId implements Serializable {
    @Serial
    private static final long serialVersionUID = 3463948451566796192L;
    @Column(name = "author_name_id", nullable = false)
    private Integer authorNameId;

    @Column(name = "author_product_id", nullable = false)
    private Integer authorProductId;

    public Integer getAuthorNameId() {
        return authorNameId;
    }

    public void setAuthorNameId(Integer authorNameId) {
        this.authorNameId = authorNameId;
    }

    public Integer getAuthorProductId() {
        return authorProductId;
    }

    public void setAuthorProductId(Integer authorProductId) {
        this.authorProductId = authorProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthorProductId entity = (AuthorProductId) o;
        return Objects.equals(this.authorNameId, entity.authorNameId) &&
                Objects.equals(this.authorProductId, entity.authorProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorNameId, authorProductId);
    }

}