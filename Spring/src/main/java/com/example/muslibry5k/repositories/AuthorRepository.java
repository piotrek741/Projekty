package com.example.muslibry5k.repositories;

import com.example.muslibry5k.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}