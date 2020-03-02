package org.wcci.blog;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.controllers.CategoryController;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.CategoryRepository;
import org.wcci.blog.storage.repos.ClientRepository;
import org.wcci.blog.storage.repos.HashTagRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CategoryStorage categoryStorage;

    @MockBean
    ClientStorage clientStorage;

    @MockBean
    PostStorage postStorage;

    @MockBean
    CategoryController catController;

    @Test
    public void shouldReturnIndexView() throws Exception{
        mockMvc.perform(get("/"))
             .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("allPosts"));

    }

}
