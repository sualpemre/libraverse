package com.libraverse.libraryservice.repository;

import com.libraverse.libraryservice.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageRepository extends JpaRepository<Language, Long> {
}