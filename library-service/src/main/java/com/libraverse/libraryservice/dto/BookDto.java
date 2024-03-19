package com.libraverse.libraryservice.dto;

import com.libraverse.libraryservice.entity.Author;
import com.libraverse.libraryservice.entity.Genre;
import com.libraverse.libraryservice.entity.Language;
import com.libraverse.libraryservice.entity.Publisher;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BookDto {
    private String id;
    private String title;
    private String isbn;
    private String description;
    private float price;
    private Date publicationDate;
    private Author author;
    private Set<Language> languages = new HashSet<>();
    private Set<Genre> genres = new HashSet<>();
    private Publisher publisher;
}
