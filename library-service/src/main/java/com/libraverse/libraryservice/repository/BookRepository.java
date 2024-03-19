package com.libraverse.libraryservice.repository;


import com.libraverse.libraryservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}