package com.libraverse.libraryservice.service.Impl;

import com.libraverse.libraryservice.entity.Book;
import com.libraverse.libraryservice.models.book.BookUpdateRequest;
import com.libraverse.libraryservice.repository.BookRepository;
import com.libraverse.libraryservice.esrepository.ElasticsearchBookRepository;
import com.libraverse.libraryservice.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ElasticsearchBookRepository bookRepository_es;
    @Override
    public Book findById(String book_id) {
        Assert.notNull(book_id, "Book id cannot be null");
        return bookRepository.findById(book_id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + book_id));
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book update(String book_id, BookUpdateRequest updateModel) {
        return null;
    }

    @Override
    public void delete(String book_id) {
        bookRepository.deleteById(book_id);
    }
}
