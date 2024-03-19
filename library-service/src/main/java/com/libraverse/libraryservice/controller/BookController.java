package com.libraverse.libraryservice.controller;

import com.libraverse.libraryservice.dto.BookDto;
import com.libraverse.libraryservice.entity.Book;
import com.libraverse.libraryservice.models.book.BookUpdateRequest;
import com.libraverse.libraryservice.service.BookService;
import com.libraverse.libraryservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping("/{book_id}")
    public ResponseEntity<BookDto> get(@PathVariable String book_id){
        Book book = bookService.findById(book_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(book, BookDto.class));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll(){
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(books, BookDto.class));
    }

    @PatchMapping("/{book_id}/update")
    public ResponseEntity<BookDto> update(@PathVariable String book_id, @RequestBody BookUpdateRequest updateModel){
        Book book = bookService.update(book_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(book, BookDto.class));
    }

    @DeleteMapping("/{book_id}/delete")
    public void delete(@PathVariable String book_id){
        bookService.delete(book_id);
    }
}
