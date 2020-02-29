package org.wcci.blog.storage.services;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.repos.ClientRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClientService implements ClientStorage {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional <Client> findByClientName(String s) {
        return clientRepository.findByClientName(s);
    }

    @Override
    public boolean existsByClientName(String s) {
        return clientRepository.existsByClientName(s);
    }

    @Override
    public void store(Client c) {
        clientRepository.save(c);
    }

    public void findClientsForPost(Post p){
        clientRepository.findAllByPosts(p);
    }
}
