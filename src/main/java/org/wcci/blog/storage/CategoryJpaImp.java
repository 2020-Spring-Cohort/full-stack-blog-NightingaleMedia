package org.wcci.blog.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repos.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryJpaImp  {


    private CategoryRepository categoryRepository;

    public CategoryJpaImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Collection <Category> findAllCategories(){
        return ( Collection <Category> )categoryRepository.findAll();
    }


}
