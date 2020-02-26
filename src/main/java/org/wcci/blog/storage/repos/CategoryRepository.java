package org.wcci.blog.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Category;

import java.util.Collection;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Collection <Category> findAllCategories();
}
