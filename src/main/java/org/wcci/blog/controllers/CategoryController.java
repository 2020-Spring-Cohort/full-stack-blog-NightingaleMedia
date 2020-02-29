package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

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
    public String displaySingleCategory(@PathVariable String categoryTitle, Model model){
        Category retrievedCategory = catStorage.findCategoryByCategoryTitle(categoryTitle);
        model.addAttribute("singleCategory", retrievedCategory);
        return "single-category";
    }

    @RequestMapping("/")
    public String displayHomePage(Model model){
         model.addAttribute("categories", catStorage.findAll());
         Iterable<Post> postIterable = postStorage.findAll();
         model.addAttribute("allPosts", postIterable);
        return "index";
    }
}
