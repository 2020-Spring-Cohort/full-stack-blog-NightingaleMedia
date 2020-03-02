package org.wcci.blog.storage;

import org.wcci.blog.models.Client;

import java.util.Optional;

public interface ClientStorage {

    Optional<Client> findByClientName(String s);

    boolean existsByClientName(String s);

    void store(Client c);

    Iterable <Client> findAll();
}
