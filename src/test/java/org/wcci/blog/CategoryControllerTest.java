package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.blog.controllers.CategoryController;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CategoryControllerTest {

    private CategoryController underTest;
    private CategoryStorage cat;
    private PostStorage post;

    private MockMvc mockMvc;
    private Model mockModel;

    @BeforeEach
    public void setup(){
        mockModel = mock(Model.class);
        cat =  mock(CategoryStorage.class);
        underTest = new CategoryController(cat, post);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneCampus() {
        Category testCampus = new Category("Tester");
        when(cat.findCategoryByCategoryTitle("Tester")).thenReturn(testCampus);
        underTest.displaySingleCategory("Tester", mockModel);
        verify(cat).findCategoryByCategoryTitle("Tester");
        verify(mockModel).addAttribute("singleCategory", testCampus);
    }

    @Test
    public void homePageShouldShowAllCategories() throws Exception{
        Category testCategory1 = new Category("Music");
        List<Category> categoryCollection = Collections.singletonList(testCategory1);

        when(cat.findAll()).thenReturn(categoryCollection);
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}
