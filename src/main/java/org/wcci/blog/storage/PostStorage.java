package org.wcci.blog.storage;

import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repos.PostRepository;

public interface PostStorage {


    void store(Post p1);

    Iterable <Post> findAll();

    Post findPostByTitle (String s);
}
