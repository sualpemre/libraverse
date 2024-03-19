package com.libraverse.libraryservice.service;

import com.libraverse.libraryservice.entity.Genre;
import com.libraverse.libraryservice.models.genre.GenreUpdateRequest;

import java.util.List;

public interface GenreService {

    Genre findById(Long genre_id);
    Genre save(Genre genre);
    List<Genre> findAll();
    Genre update(Long genre_id, GenreUpdateRequest updateModel);
    void delete(Long genre_id);
}
