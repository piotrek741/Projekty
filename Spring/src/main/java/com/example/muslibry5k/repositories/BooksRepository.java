package com.example.muslibry5k.repositories;

import com.example.muslibry5k.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}