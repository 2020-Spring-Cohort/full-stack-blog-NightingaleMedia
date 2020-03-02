package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.HashTag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

@Component
public class Populator implements CommandLineRunner {


    public CategoryStorage catStorage;
    public ClientStorage clientStorage;
    public PostStorage postStorage;
    public HashTagStorage hashStorage;

    public Populator(CategoryStorage catStorage, ClientStorage clientStorage, PostStorage postStorage, HashTagStorage hashStorage) {
        this.catStorage = catStorage;
        this.clientStorage = clientStorage;
        this.postStorage = postStorage;
        this.hashStorage = hashStorage;
    }

    @Override
    public void run(String... args) {
        Category c1 = new Category("Music");
        catStorage.store(c1);

        Category c2 = new Category("Tech");
        catStorage.store(c2);

        Category c3 = new Category("Design");
        catStorage.store(c3);

        Category c4 = new Category("Writing");
        catStorage.store(c4);

        Client cl1 = new Client("WeCanCode IT");
        clientStorage.store(cl1);

        Client cl2 = new Client("BlackMath");
        clientStorage.store(cl2);

        Client cl3 = new Client("Oranjudio Columbus");
        clientStorage.store(cl3);

        Client cl4 = new Client("Nightingale Media");
        clientStorage.store(cl4);

        Post p1 = new Post("About This Blog", c2, "", cl1);
        p1.setContent("This blog is a content management system created by Al Sigman " +
                "and made to keep track of all of my various freelance projects.  " +
                "Projects are organized by category and are sub-typed using clients.");
        p1.setDate(2020);

        Post p2 = new Post("Working Towards Something",c1, "I love to make music" +
                "projects and I love taking time to learn new instruments and songs.", cl2, cl1);
        Post p3 = new Post("A Designer's Delight", c3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",cl2,cl3);
        Post p4 = new Post("Raspberry Pi", c2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",cl4);
        Post p5 = new Post("Writing Away", c4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", cl3, cl1);

        postStorage.store(p1);
        postStorage.store(p2);
        postStorage.store(p3);
        postStorage.store(p4);
        postStorage.store(p5);

    }

//    @Bean
//    public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
//        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
//        factory.setResources(new Resource[]{new ClassPathResource("blog-data.json")});
//        return factory;
//    }



}
