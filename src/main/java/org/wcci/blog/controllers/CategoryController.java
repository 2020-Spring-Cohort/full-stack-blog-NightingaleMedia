package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

import java.util.Optional;

@Controller
public class CategoryController {

    private CategoryStorage catStorage;
    private PostStorage postStorage;

    public CategoryController(CategoryStorage catStorage,
                              PostStorage postStorage) {
        this.catStorage = catStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("/{categoryTitle}")
    public String displaySingleCategory(
            @PathVariable String categoryTitle, Model model){
        Category retrievedCategory = catStorage.findCategoryByCategoryTitle(categoryTitle);
        Iterable <Post> postList = postStorage.findAllByCategory(retrievedCategory);
        model.addAttribute("singleCategory", retrievedCategory);
        model.addAttribute("posts", postList);
        return "single-category";
    }

    @RequestMapping("/")
    public String displayHomePage(Model model){
         model.addAttribute("categories", catStorage.findAll());
         Iterable<Post> postIterable = postStorage.findAll();
         model.addAttribute("allPosts", postIterable);
        return "index";
    }

    @RequestMapping("/categories")
    public String displayAllCategories(Model model){
        model.addAttribute("categories", catStorage.findAll());
        return "all-categories";
    }

    @GetMapping("add-category")
        public String addCategoryGet(){
        return "add-category";
        }

    @PostMapping("add-category")
    public String addCategoryPost(@RequestParam String catTitle){
        if(!catStorage.categoryExistsByTitle(catTitle)) {
            Category catToAdd = new Category(catTitle);
            catStorage.store(catToAdd);
        } return "redirect:/categories";
    }

}
