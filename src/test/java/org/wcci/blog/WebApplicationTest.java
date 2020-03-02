package org.wcci.blog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.controllers.CategoryController;

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryController categoryController;

    @Test
    public void shouldReturnIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}