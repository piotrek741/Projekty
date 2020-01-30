package com.example.muslibry5k.controllers;

import com.example.muslibry5k.repositories.LibraryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {

    private LibraryRepository LibraryRepository;

    public LibraryController(LibraryRepository LibraryRepository) {
        this.LibraryRepository = LibraryRepository;
    }

    @RequestMapping("/Library")
    public String getLibrary(Model model) {
        model.addAttribute("Library", LibraryRepository.findAll());
        return "Library";
    }

}
