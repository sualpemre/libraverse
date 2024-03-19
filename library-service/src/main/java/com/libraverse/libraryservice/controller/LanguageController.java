package com.libraverse.libraryservice.controller;

import com.libraverse.libraryservice.dto.LanguageDto;
import com.libraverse.libraryservice.entity.Language;
import com.libraverse.libraryservice.models.language.LanguageUpdateRequest;
import com.libraverse.libraryservice.service.LanguageService;
import com.libraverse.libraryservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;
    @GetMapping("/{language_id}")
    public ResponseEntity<LanguageDto> get(@PathVariable Long language_id){
        Language language = languageService.findById(language_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(language, LanguageDto.class));
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAll(){
        List<Language> languages = languageService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(languages, LanguageDto.class));
    }

    @PatchMapping("/{language_id}/update")
    public ResponseEntity<LanguageDto> update(@PathVariable Long language_id, @RequestBody LanguageUpdateRequest updateModel){
        Language genre = languageService.update(language_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(genre, LanguageDto.class));
    }

    @DeleteMapping("/{language_id}/delete")
    public void delete(@PathVariable Long language_id){
        languageService.delete(language_id);
    }
}
