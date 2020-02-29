package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class PostController {


    @Autowired
    private PostStorage postStorage;
    @Autowired
    private ClientStorage clientStorage;
    @Autowired
    private HashTagStorage hashTagStorage;

    @GetMapping("/{categoryTitle}/{postTitle}")
    public String displaySinglePost(@PathVariable String postTitle, String categoryTitle, Model model){
        Post retrievedPost = postStorage.findPostByTitle(postTitle);
//        Category catForPost = retrievedPost.getPostCategory();
//        String categoryTitle = catForPost.getCategoryTitle();
        model.addAttribute("postContent", retrievedPost);
        return "blog-detail";
    }



}
