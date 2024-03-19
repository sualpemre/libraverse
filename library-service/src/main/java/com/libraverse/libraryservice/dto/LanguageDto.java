package com.libraverse.libraryservice.dto;

import com.libraverse.libraryservice.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class LanguageDto {
    private Long id;
    private String name;
    private Set<Book> books = new HashSet<>();
}
