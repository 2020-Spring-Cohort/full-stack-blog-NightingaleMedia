package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
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

        Post p1 = new Post("Get Some Money", c1);
        postStorage.store(p1);

        Post p2 = new Post("Get Some More Money", c1);
        postStorage.store(p2);

        Client cL1 = new Client("BlackMath");
        clientStorage.store(cL1);

        Client cL2 = new Client("Real Stuff");
        clientStorage.store(cL2);

        p1.addClient(cL1);
        p1.addClient(cL2);
        postStorage.store(p1);


    }
}
