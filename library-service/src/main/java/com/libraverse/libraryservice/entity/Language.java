package com.libraverse.libraryservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
@Entity
@Table(name="language")
@DynamicUpdate
public class Language {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false)
    private Long id;
    @Column(name = "language_name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "languages", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<Book> books = new HashSet<>();

}
