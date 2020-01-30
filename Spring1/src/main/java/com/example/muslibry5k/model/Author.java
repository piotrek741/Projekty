package com.example.muslibry5k.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;

    @ManyToMany
    private Set<Books> books = new HashSet<>();

    @ManyToMany
    private Set<Library> Library = new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName, String nick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
    }

    public Author(String firstName, String lastName, String nick, Set<Books> Books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.books = Books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> Books) {
        this.books = Books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", Books=" + books +
                '}';
    }

    public Collection<com.example.muslibry5k.model.Books> getBookss() {
        return null;
    }
}
