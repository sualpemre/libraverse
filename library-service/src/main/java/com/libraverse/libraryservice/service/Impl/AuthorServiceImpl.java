package com.libraverse.libraryservice.service.Impl;

import com.libraverse.libraryservice.entity.Author;
import com.libraverse.libraryservice.models.author.AuthorUpdateRequest;
import com.libraverse.libraryservice.repository.AuthorRepository;
import com.libraverse.libraryservice.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public Author findById(String author_id) {
        Assert.notNull(author_id, "Author id cannot be null");
        return authorRepository.findById(author_id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + author_id));
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author update(String author_id, AuthorUpdateRequest updateModel) {
        return null;
    }

    @Override
    public void delete(String author_id) {
        authorRepository.deleteById(author_id);
    }
}
