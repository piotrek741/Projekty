package com.example.muslibry5k.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private String ismn;
    private String year;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Library Library;

    @ManyToMany
    private Set<Author> Author = new HashSet<>();

    public Books() {
    }

    public Books(String title, String genre, String ismn, String year, Publisher publisher, Library Library) {
        this.title = title;
        this.genre = genre;
        this.ismn = ismn;
        this.year = year;
        this.publisher = publisher;
        this.Library = Library;
    }

    public Books(String title, String genre, String ismn, String year, Publisher publisher, Set<Author> Author, Library Library) {
        this.title = title;
        this.genre = genre;
        this.ismn = ismn;
        this.year = year;
        this.publisher = publisher;
        this.Author = Author;
        this.Library = Library;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsmn() {
        return ismn;
    }

    public void setIsmn(String ismn) {
        this.ismn = ismn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<Author> getAuthor() {
        return Author;
    }

    public void setAuthor(Set<Author> Author) {
        this.Author = Author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Library getLibrary() {
        return Library;
    }

    public void setLibrary(Library Library) {
        this.Library = Library;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", ismn='" + ismn + '\'' +
                ", year='" + year + '\'' +
                ", publisher=" + publisher + '\'' +
                ", Library=" + Library +
                '}';
    }

    public Collection<com.example.muslibry5k.model.Author> getAuthors() {
        return null;
    }
}