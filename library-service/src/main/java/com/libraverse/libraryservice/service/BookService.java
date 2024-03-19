package com.libraverse.libraryservice.service;

import com.libraverse.libraryservice.entity.Book;
import com.libraverse.libraryservice.models.book.BookUpdateRequest;

import java.util.List;

public interface BookService {
    Book findById(String book_id);
    Book save(Book book);
    List<Book> findAll();
    Book update(String book_id, BookUpdateRequest updateModel);
    void delete(String book_id);
}
