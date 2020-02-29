package org.wcci.blog.storage;

import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repos.PostRepository;

import java.util.List;

public interface PostStorage {



    void store(Post p1);

    Iterable <Post> findAll();

    Post findPostByTitle (String s);

    Iterable<Post> findAllByCategory(Category retrievedCategory);
}
