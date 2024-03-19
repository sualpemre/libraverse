package com.libraverse.libraryservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
@Entity
@Table(name="genre")
@DynamicUpdate
public class Genre {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long id;

    @Column(name = "genre_name", nullable = false)
    private String name;
}
