package org.wcci.blog.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.models.Client;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.ClientStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class ClientController {

    @Autowired
    private ClientStorage clientStorage;

    @Autowired
    private PostStorage postStorage;

    @GetMapping("/clients")
    public String displayAllClients(Model model){
        model.addAttribute("clients", clientStorage.findAll());
        return "all-clients";
    }

    @GetMapping("/clients/{clientTitle}")
    public String displayPostsForClient(Model model,
                                        @PathVariable String clientTitle){
        Client client = clientStorage.findByClientName(clientTitle).get();
        model.addAttribute("clientInfo", client);
        Iterable <Post> posts = postStorage.findPostsByClient(client);
        model.addAttribute("postInfo", posts);
        return "single-client";
    }

}
