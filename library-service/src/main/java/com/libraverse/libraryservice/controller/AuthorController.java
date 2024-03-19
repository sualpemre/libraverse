package com.libraverse.libraryservice.controller;


import com.libraverse.libraryservice.dto.AuthorDto;
import com.libraverse.libraryservice.entity.Author;
import com.libraverse.libraryservice.models.author.AuthorUpdateRequest;
import com.libraverse.libraryservice.service.AuthorService;
import com.libraverse.libraryservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {


    private final AuthorService authorService;
    @GetMapping("/{author_id}")
    public ResponseEntity<AuthorDto> get(@PathVariable String author_id){
        Author author = authorService.findById(author_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(author, AuthorDto.class));
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll(){
        List<Author> authors = authorService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(authors, AuthorDto.class));
    }

    @PatchMapping("/{author_id}/update")
    public ResponseEntity<AuthorDto> update(@PathVariable String author_id, @RequestBody AuthorUpdateRequest updateModel){
        Author author = authorService.update(author_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(author, AuthorDto.class));
    }

    @DeleteMapping("/{author_id}/delete")
    public void delete(@PathVariable String author_id){
        authorService.delete(author_id);
    }
}
