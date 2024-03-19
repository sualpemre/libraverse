package com.libraverse.libraryservice.service;

import com.libraverse.libraryservice.entity.Language;
import com.libraverse.libraryservice.models.language.LanguageUpdateRequest;

import java.util.List;

public interface LanguageService {
    Language findById(Long language_id);
    Language save(Language language);
    List<Language> findAll();
    Language update(Long language_id, LanguageUpdateRequest updateModel);
    void delete(Long language_id);
}
