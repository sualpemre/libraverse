package com.libraverse.libraryservice.dto;

import com.libraverse.libraryservice.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

@Getter
@Setter
public class AuthorDto {
    private String id;
    private String name;
    private Date birthDate;
    private String biography;
    private Set<Book> books = new HashSet<>();
}
