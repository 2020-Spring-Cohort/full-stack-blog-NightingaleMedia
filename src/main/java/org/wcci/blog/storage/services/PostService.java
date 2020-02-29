package org.wcci.blog.storage.services;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.PostRepository;

import java.util.Collection;
import java.util.List;

@Service
public class PostService implements PostStorage {
    public PostRepository postRepo;

    public PostService (PostRepository postRepo){
        this.postRepo = postRepo;
    }


    @Override
    public void store(Post p) {
        postRepo.save(p);
    }

    @Override
    public List<Post> findAll() {
        return (List <Post>) postRepo.findAll();
    }

    @Override
    public Post findPostByTitle(String s) {
        return postRepo.findByPostTitle(s);
    }
}