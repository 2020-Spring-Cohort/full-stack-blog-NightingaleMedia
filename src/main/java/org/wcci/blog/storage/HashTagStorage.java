package org.wcci.blog.storage;

import org.wcci.blog.models.HashTag;

public interface HashTagStorage {
    void store(HashTag h);

    HashTag findTagByName(String name);

    boolean TagByNameExists(String tag);
}
