package org.wcci.blog.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository <Post, Long>{

Post findByPostTitle(String t);

Post findAllByPostCategory(Category c);

}
