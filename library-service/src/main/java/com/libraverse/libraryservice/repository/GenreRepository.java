package com.libraverse.libraryservice.repository;

import com.libraverse.libraryservice.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenreRepository extends JpaRepository<Genre, Long> {
}