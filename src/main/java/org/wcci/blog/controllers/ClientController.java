package org.wcci.blog.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
