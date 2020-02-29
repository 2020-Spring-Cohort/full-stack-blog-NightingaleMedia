package org.wcci.blog.models;

import org.wcci.blog.storage.CategoryStorage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Collection;
import java.util.List;

@Entity
public class Category {

    public Category(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category(){}

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "postCategory")
    private Collection<Post> posts;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    private String categoryTitle;


    public Collection <Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        return categoryTitle != null ? categoryTitle.equals(category.categoryTitle) : category.categoryTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryTitle != null ? categoryTitle.hashCode() : 0);
        return result;
    }
}


