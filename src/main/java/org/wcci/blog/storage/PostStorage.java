package org.wcci.blog.storage;

import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;

import java.util.Optional;

public interface PostStorage {

//    Iterable <Post> findAllByClient(Client c);


    void store(Post p1);

    Iterable <Post> findAll();

    Post findPostByTitle (String s);

    Iterable <Post> findAllByCategory(Category retrievedCategory);

    Iterable<Post> findPostsByClient(Client client);
}
