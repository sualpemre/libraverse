package com.libraverse.libraryservice.models.author;

import com.libraverse.libraryservice.entity.Book;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AuthorUpdateRequest {

    private String name;
    private Date birthDate;
    private String biography;
    private Set<Book> books = new HashSet<>();
}
