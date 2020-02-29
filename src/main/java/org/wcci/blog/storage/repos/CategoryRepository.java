package org.wcci.blog.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findCategoryByCategoryTitle(String c);
}
