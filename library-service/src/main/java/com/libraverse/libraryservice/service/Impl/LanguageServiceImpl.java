package com.libraverse.libraryservice.service.Impl;

import com.libraverse.libraryservice.entity.Language;
import com.libraverse.libraryservice.models.language.LanguageUpdateRequest;
import com.libraverse.libraryservice.repository.LanguageRepository;
import com.libraverse.libraryservice.service.LanguageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    @Override
    public Language findById(Long language_id) {
        Assert.notNull(language_id, "Author id cannot be null");
        return languageRepository.findById(language_id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + language_id));
    }

    @Override
    public Language save(Language language) {
        return null;
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language update(Long language_id, LanguageUpdateRequest updateModel) {
        return null;
    }

    @Override
    public void delete(Long language_id) {
        languageRepository.deleteById(language_id);
    }
}
