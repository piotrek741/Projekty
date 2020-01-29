package com.example.muslibry5k.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String LibraryName;
    private String YearofCreationLibrary;

    @ManyToMany
    private Set<Artist> Author = new HashSet<>();

    public Library() {
    }

    public Library(String LibraryName, String YearofCreationLibrary) {
        this.LibraryName = LibraryName;
        this.YearofCreationLibrary = YearofCreationLibrary;
    }

    public Library(String LibraryName, String YearofCreationLibrary, Set<Artist> Author) {
        this.LibraryName = LibraryName;
        this.YearofCreationLibrary = YearofCreationLibrary;
        this.Author = Author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibraryName() {
        return LibraryName;
    }

    public void setLibraryName(String LibraryName) {
        this.LibraryName = LibraryName;
    }

    public String getYearofCreationLibrary() {
        return YearofCreationLibrary;
    }

    public void setYearofCreationLibrary(String YearofCreationLibrary) {
        this.YearofCreationLibrary = YearofCreationLibrary;
    }

    public Set<Artist> getAuthor() {
        return Author;
    }

    public void setAuthor(Set<Artist> Author) {
        this.Author = Author;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", LibraryName='" + LibraryName + '\'' +
                ", YearofCreationLibrary='" + YearofCreationLibrary + '\'' +
                '}';
    }
}