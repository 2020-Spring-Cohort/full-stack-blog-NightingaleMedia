package org.wcci.blog.controllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.misusing.NotAMockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.PostStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class postControllerTest {


    private PostStorage postStorage;

    private PostController underTest;

    private MockMvc mockMvc;
    private Model mockModel;

    private Category cat1;
    private Post testPost1;

    @BeforeEach
    public void setup(){
        postStorage = mock(PostStorage.class);
        underTest = new PostController(postStorage);

        cat1 = new Category("tester");
        testPost1 = new Post("TestPost1", cat1);
        mockModel = mock(Model.class);
        when(postStorage.findPostByTitle("TestPost1")).thenReturn(testPost1);
    }
    @Test
    public void shouldGetThePostView(){
        String result = underTest.displaySinglePost("TestPost1", mockModel);
        assertThat(result).isEqualTo("blog-detail");
    }

    @Test
    public void postShouldInteractWithDependencies() throws NotAMockException {

        underTest.displaySinglePost("TestPost1", mockModel);
//        verify(postStorage.findPostByTitle("TestPost1"));
        verify(mockModel).addAttribute("postContent", testPost1);


    }
}
