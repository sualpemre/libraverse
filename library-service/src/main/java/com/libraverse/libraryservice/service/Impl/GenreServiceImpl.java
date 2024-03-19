package com.libraverse.libraryservice.service.Impl;

import com.libraverse.libraryservice.entity.Genre;
import com.libraverse.libraryservice.models.genre.GenreUpdateRequest;
import com.libraverse.libraryservice.repository.GenreRepository;
import com.libraverse.libraryservice.service.GenreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    @Override
    public Genre findById(Long genre_id) {
        Assert.notNull(genre_id, "Genre id cannot be null");
        return genreRepository.findById(genre_id)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found with id: " + genre_id));
    }

    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre update(Long genre_id, GenreUpdateRequest updateModel) {
        return null;
    }

    @Override
    public void delete(Long genre_id) {
        genreRepository.deleteById(genre_id);
    }
}
