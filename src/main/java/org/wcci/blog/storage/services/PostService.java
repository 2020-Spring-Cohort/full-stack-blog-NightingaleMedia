package org.wcci.blog.storage.services;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.ClientRepository;
import org.wcci.blog.storage.repos.PostRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostStorage {
    public PostRepository postRepo;


    public PostService (PostRepository postRepo){
        this.postRepo = postRepo;

    }

//    @Override
//    public Iterable<Post> findAllByClient(Client c) {
//        return postRepo.findAllByClientsIn(c);
//    }

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

    @Override
    public Iterable <Post> findAllByCategory(Category retrievedCategory) {
        return postRepo.findAllByPostCategory(retrievedCategory);
    }

    @Override
    public Iterable<Post> findPostsByClient(Client client) {
        return postRepo.findAllByClients(client);
    }
}
