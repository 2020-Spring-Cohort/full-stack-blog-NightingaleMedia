package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.HashTag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repos.CategoryRepository;
import org.wcci.blog.storage.repos.ClientRepository;
import org.wcci.blog.storage.repos.HashTagRepository;
import org.wcci.blog.storage.repos.PostRepository;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private EntityManager testEntityMan;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ClientRepository clientRepository;

    private Category testCat1;
    private HashTag testHas1;
    private Post testPost1;
    private Post testPost2;
    private Client client1;
    private Client client2;


    @BeforeEach
    void setUp() {
        testCat1 = new Category("Music");
        testPost1 = new Post("Best Project", testCat1, client1);
        testPost2 = new Post ("second best project", testCat1);
        testHas1 = new HashTag("tag1");

        client2 = new Client("Tesla");
        client1 = new Client("Starbucks");
        clientRepository.save(client1);
        clientRepository.save(client2);

        categoryRepository.save(testCat1);
        postRepository.save(testPost1);

        hashTagRepository.save(testHas1);

        testEntityMan.flush();
        testEntityMan.clear();
    }

    @Test
    public void categoryShouldHaveManyPosts(){

        Category retrievedCategory = categoryRepository.findCategoryByCategoryTitle("Music");
        assertThat(retrievedCategory.getCategoryTitle()).isEqualTo("Music");
        assertThat(retrievedCategory.getPosts().contains(testPost1));
    }

    @Test
    public void postShouldHaveManyClients(){

        testPost1.addClient(client2);
        postRepository.save(testPost1);
        testEntityMan.flush();
        testEntityMan.clear();

        assertThat(testPost1.getClients().contains(client1));
        assertThat(testPost1.getClients().contains(client2));
    }

    @Test
    public void postCanHaveManyHashTags(){
        testPost1.addHashTag(testHas1);
        assertThat(testPost1.getHashTagsForPost().contains(testHas1));
    }

    @Test
    public void clientCanHaveManyPosts(){
        testPost1.addClient(client1);
        testPost2.addClient(client1);

        assertThat(testPost1.getClients().contains(client1));
        assertThat(testPost2.getClients().contains(client2));

    }

    @Test
    public void PostCanHaveManyHashTags(){
        HashTag h1 = new HashTag("testing1");
        HashTag h2 = new HashTag("testing2");
        hashTagRepository.save(h1);
        hashTagRepository.save(h2);
        testPost1.addHashTag(h1);
        testPost1.addHashTag(h2);
        postRepository.save(testPost1);

        assertThat(testPost1.getHashTagsForPost()).contains(h1, h2);

    }

}
