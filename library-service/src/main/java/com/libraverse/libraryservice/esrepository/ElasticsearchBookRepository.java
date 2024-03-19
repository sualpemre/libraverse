package com.libraverse.libraryservice.esrepository;

import com.libraverse.libraryservice.models.es.BookModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticsearchBookRepository extends ElasticsearchRepository<BookModel, String> {
}
