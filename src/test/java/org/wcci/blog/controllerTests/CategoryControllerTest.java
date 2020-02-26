package org.wcci.blog.controllerTests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.CategoryController;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repos.CategoryRepository;

public class CategoryControllerTest {

    private CategoryController underTest;
    private MockMvc mockMvc;
    private CategoryRepository cateRepo;



    @BeforeEach
    public void setup(){
        mockMvc = new mock(Model.class)
        underTest = new CategoryController(cateRepo);
    }
    @Test
    public void homePageShouldShowAllCategories(){
        Category testCategory1 = new Category("Music");
        Category testCategory2 = new Category("Art");
        Category testCategory3 = new Category("Design");




    }
}
