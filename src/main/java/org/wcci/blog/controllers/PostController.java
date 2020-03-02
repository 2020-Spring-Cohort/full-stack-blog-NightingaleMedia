package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.HashTag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.PostStorage;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private CategoryStorage categoryStorage;

    @Autowired
    private ClientStorage clientStorage;

    private HashTagStorage hashTagStorage;
    private PostStorage postStorage;

    public PostController(PostStorage postStorage, HashTagStorage hashTagStorage) {
        this.postStorage = postStorage;
        this.hashTagStorage = hashTagStorage;
    }


    @GetMapping("/{categoryTitle}/{postTitle}")
    public String displaySinglePost(@PathVariable String postTitle, Model model){
        Post retrievedPost = postStorage.findPostByTitle(postTitle);
//        Category catForPost = retrievedPost.getPostCategory();
//        String categoryTitle = catForPost.getCategoryTitle();
        model.addAttribute("postContent", retrievedPost);
        return "blog-detail";
    }

    @PostMapping("/add-tag")
    public String addHashTag(@RequestParam String tag, String postTitle){
        Post postToAddHash = postStorage.findPostByTitle(postTitle);
        String categoryTitle = postToAddHash.getCategoryTitle();

        HashTag hashToAddToPost;
        if(hashTagStorage.TagByNameExists(tag)) {
            hashToAddToPost = hashTagStorage.findTagByName(tag);
        } else {
            hashToAddToPost = new HashTag(tag);
            hashTagStorage.store(hashToAddToPost);
        }
        postToAddHash.addHashTag(hashToAddToPost);
        postStorage.store(postToAddHash);
        return "redirect:/" + categoryTitle +"/"+ postTitle;
    }

    @GetMapping("/add-post")
    public String addNewTemplate(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryStorage.findAll());
        return "add-post";
    }
    @PostMapping("/add-post")
    public  String addNewPost(@ModelAttribute Post post, @RequestParam String catTitle, String client){
        Post postToStore;
        Client clientToStore;
        Optional<Client> clientToStoreOpt = clientStorage.findByClientName(client);
        Category category = categoryStorage.findCategoryByCategoryTitle(catTitle);
        if(client.length()>0) {
            if (!clientToStoreOpt.isEmpty()) {
                clientToStore = clientStorage.findByClientName(client).get();
            } else {
                clientToStore = new Client(client);
                clientStorage.store(clientToStore);
            }
            postToStore = new Post(post.getPostTitle(), category, clientToStore);
        } else {
            postToStore = new Post(post.getPostTitle(), category);
        }
        postStorage.store(postToStore);
        return "redirect:/";
    }



}
