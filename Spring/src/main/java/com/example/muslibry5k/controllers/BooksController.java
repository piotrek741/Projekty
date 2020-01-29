package com.example.muslibry5k.controllers;

import com.example.muslibry5k.model.Books;
import com.example.muslibry5k.repositories.LibraryRepository;
import com.example.muslibry5k.repositories.PublisherRepository;
import com.example.muslibry5k.repositories.BooksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {

    private BooksRepository BooksRepository;
    private PublisherRepository publisherRepository;
    private LibraryRepository LibraryRepository;

    public BooksController(BooksRepository BooksRepository, PublisherRepository publisherRepository, LibraryRepository LibraryRepository) {
        this.BooksRepository = BooksRepository;
        this.publisherRepository = publisherRepository;
        this.LibraryRepository = LibraryRepository;
    }

    @GetMapping("/Bookss")
    public String getBookss(Model model) {
        model.addAttribute("Bookss", BooksRepository.findAll());
        return "Bookss";
    }

    @GetMapping("/addBooks")
    public String sendFormAddBooks(Books Books){
        return "addBooks";
    }

    @PostMapping("/addBooks")
    public String processFormAddBooks(Books Books){
        publisherRepository.save(Books.getPublisher());
        LibraryRepository.save(Books.getLibrary());
        BooksRepository.save(Books);
        return "showMessage";
    }

}