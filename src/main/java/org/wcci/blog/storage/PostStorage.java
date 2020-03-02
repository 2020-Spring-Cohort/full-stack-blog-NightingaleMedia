package org.wcci.blog.storage;

import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;

import java.util.Optional;

public interface PostStorage {



    void store(Post p1);

    Iterable <Post> findAll();

    Post findPostByTitle (String s);

    Post findAllByCategory(Category retrievedCategory);
}
