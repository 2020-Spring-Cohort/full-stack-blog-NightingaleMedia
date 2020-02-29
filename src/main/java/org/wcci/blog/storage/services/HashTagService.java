package org.wcci.blog.storage.services;

import org.springframework.stereotype.Service;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.repos.HashTagRepository;

@Service
public class HashTagService implements HashTagStorage {

    private HashTagRepository hashRepo;

    public HashTagService(HashTagRepository hashRepo) {
        this.hashRepo = hashRepo;
    }

}
