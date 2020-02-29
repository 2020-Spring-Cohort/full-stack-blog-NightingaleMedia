package org.wcci.blog.models;

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
}
