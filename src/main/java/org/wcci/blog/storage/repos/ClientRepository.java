package org.wcci.blog.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository <Client, Long> {

    Collection<Client> findAllByPosts(Post p);

    Optional<Client> findByClientName(String s);


    boolean existsByClientName(String s);
}
