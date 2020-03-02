package org.wcci.blog.storage.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.models.HashTag;

@Repository
public interface HashTagRepository extends CrudRepository <HashTag, Long> {

    HashTag findHashTagByTag(String t);

    boolean existsHashTagByTag(String t);
}
