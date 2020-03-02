package org.wcci.blog.storage.services;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.HashTag;
import org.wcci.blog.storage.HashTagStorage;
import org.wcci.blog.storage.repos.HashTagRepository;

@Service
public class HashTagService implements HashTagStorage {

    private HashTagRepository hashRepo;

    public HashTagService(HashTagRepository hashRepo) {
        this.hashRepo = hashRepo;
    }

    @Override
    public void store(HashTag h) {
        hashRepo.save(h);
    }

    @Override
    public HashTag findTagByName(String name) {
        return hashRepo.findHashTagByTag(name);
    }

    @Override
    public boolean TagByNameExists(String tag) {
        return hashRepo.existsHashTagByTag(tag);
    }

}
