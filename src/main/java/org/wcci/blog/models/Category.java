package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Category {

    public Category(){}

    @Id
    @GeneratedValue
    private Long id;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    private String categoryTitle;

    @OneToMany(mappedBy = "category")
    private Collection <Post> posts;

    public Category(String categoryTitle) {
    }
}
