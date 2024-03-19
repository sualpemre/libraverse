package com.libraverse.libraryservice.repository;

import com.libraverse.libraryservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}

