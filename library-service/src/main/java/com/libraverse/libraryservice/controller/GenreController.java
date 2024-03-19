package com.libraverse.libraryservice.controller;



import com.libraverse.libraryservice.dto.GenreDto;
import com.libraverse.libraryservice.entity.Genre;
import com.libraverse.libraryservice.models.genre.GenreUpdateRequest;
import com.libraverse.libraryservice.service.GenreService;
import com.libraverse.libraryservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    @GetMapping("/{genre_id}")
    public ResponseEntity<GenreDto> get(@PathVariable Long genre_id){
        Genre genre = genreService.findById(genre_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(genre, GenreDto.class));
    }

    @GetMapping
    public ResponseEntity<List<GenreDto>> getAll(){
        List<Genre> genres = genreService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(genres, GenreDto.class));
    }

    @PatchMapping("/{genre_id}/update")
    public ResponseEntity<GenreDto> update(@PathVariable Long genre_id, @RequestBody GenreUpdateRequest updateModel){
        Genre genre = genreService.update(genre_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(genre, GenreDto.class));
    }

    @DeleteMapping("/{genre_id}/delete")
    public void delete(@PathVariable Long genre_id){
        genreService.delete(genre_id);
    }
}
