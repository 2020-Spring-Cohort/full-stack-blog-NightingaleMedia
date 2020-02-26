package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("categories", categoryRepository.findAllCategories());
        return "index.html";
    }
}
