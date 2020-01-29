package com.example.muslibry5k.tools;

import com.example.muslibry5k.model.Library;
import com.example.muslibry5k.model.Author;
import com.example.muslibry5k.model.Publisher;
import com.example.muslibry5k.model.Books;
import com.example.muslibry5k.repositories.LibraryRepository;
import com.example.muslibry5k.repositories.AuthorRepository;
import com.example.muslibry5k.repositories.PublisherRepository;
import com.example.muslibry5k.repositories.BooksRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(BooksRepository BooksRepository, AuthorRepository AuthorRepository, PublisherRepository publisherRepository, LibraryRepository LibraryRepository) {
        this.BooksRepository = BooksRepository;
        this.AuthorRepository = AuthorRepository;
        this.publisherRepository = publisherRepository;
        this.LibraryRepository = LibraryRepository;
    }

    private BooksRepository BooksRepository;
    private AuthorRepository AuthorRepository;
    private PublisherRepository publisherRepository;
    private LibraryRepository LibraryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author Christie = new Author("Christie", "Golden", "Golden");
        Publisher France = new Publisher("France Records", "12", "32");
        Library LibraryeOne = new Library("Kolorowa", "1233");
        Books Warcraft = new Books("Warcraft", "fantasy", "1983129873",
                "2012", France, LibraryeOne);
        Christie.getBookss().add(Warcraft);
        Warcraft.getAuthors().add(Christie);
        publisherRepository.save(France);
        LibraryRepository.save(LibraryeOne);
        AuthorRepository.save(Christie);
        BooksRepository.save(Warcraft);


        Author Andrzej = new Author("Andrzej", "Sapkowski", "Andrzej");
        Publisher island = new Publisher("Island Records","12", "32");
        Library LibraryeTwo = new Library("Biblioteca Nacional de Mexico", "1233");
        Books Wiedzmin = new Books("Wiedzmin", "fantasy", "98172391123",
                "2002", island, LibraryeTwo);
        Andrzej.getBookss().add(Wiedzmin);
        Wiedzmin.getAuthors().add(Andrzej);
        publisherRepository.save(island);
        LibraryRepository.save(LibraryeTwo);
        AuthorRepository.save(Andrzej);
        BooksRepository.save(Wiedzmin);


        Author Stephen = new Author("Stephen", "King", "Stephen");
        Publisher Albatros = new Publisher("Albatros", "12", "32");
        Library LibraryeThree = new Library("Public Library in Seattle", "1233");
        Books It = new Books("It", "Creepy", "09309823091",
                "2018", Albatros, LibraryeThree);
        Stephen.getBookss().add(It);
        It.getAuthors().add(Stephen);
        publisherRepository.save(Albatros);
        LibraryRepository.save(LibraryeThree);
        AuthorRepository.save(Stephen);
        BooksRepository.save(It);

    }
}