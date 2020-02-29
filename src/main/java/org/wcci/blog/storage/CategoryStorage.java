package org.wcci.blog.storage;

import org.wcci.blog.models.Category;

import java.util.Collection;

public interface CategoryStorage {

    Category findCategoryByCategoryTitle(String categoryTitle);

    Collection<Category> findAll();

    void store(Category c1);
}
