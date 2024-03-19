package com.libraverse.libraryservice.service;

import com.libraverse.libraryservice.entity.Author;
import com.libraverse.libraryservice.models.author.AuthorUpdateRequest;

import java.util.List;

public interface AuthorService {
    Author findById(String author_id);
    Author save(Author author);
    List<Author> findAll();
    Author update(String author_id, AuthorUpdateRequest updateModel);
    void delete(String author_id);
}
