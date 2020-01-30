package com.example.muslibry5k.controllers;

import com.example.muslibry5k.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository AuthorRepository;

    public AuthorController(AuthorRepository AuthorRepository) {
        this.AuthorRepository = AuthorRepository;
    }

    @RequestMapping("/Authors")
    public String getAuthors(Model model) {
        model.addAttribute("Authors", AuthorRepository.findAll());
        return "Authors";
    }
}