package org.wcci.blog.storage.services;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.repos.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryService implements CategoryStorage {

    private CategoryRepository catRepo;

    public CategoryService(CategoryRepository catRepo) {
        this.catRepo = catRepo;
    }


    @Override
    public Category findCategoryByCategoryTitle(String categoryTitle) {
        return catRepo.findCategoryByCategoryTitle(categoryTitle);
    }

    @Override
    public boolean categoryExistsByTitle(String s) {
        return catRepo.existsByCategoryTitle(s);
    }

    @Override
    public Collection<Category> findAll() {
        return (Collection <Category> )catRepo.findAll();
    }

    @Override
    public void store(Category c) {
        catRepo.save(c);
    }
}
