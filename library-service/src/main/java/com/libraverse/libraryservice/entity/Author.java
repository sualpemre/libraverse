package com.libraverse.libraryservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
@Entity
@Table(name="author")
@DynamicUpdate
public class Author {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "author_id", nullable = false)
    private String id;
    private String name;
    private Date birthDate;
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();
}
