package com.libraverse.libraryservice.models.es;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = { "id" } )
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "book")
public class BookModel implements Serializable {
    @Id
    private String id;
    private String title;
    private String isbn;
    private String description;
    private float price;
}
