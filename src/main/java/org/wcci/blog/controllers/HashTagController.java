package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.wcci.blog.storage.HashTagStorage;

@Controller
public class HashTagController {

    private HashTagStorage hashStorage;

    public HashTagController(HashTagStorage hashStorage) {
        this.hashStorage = hashStorage;
    }
}
