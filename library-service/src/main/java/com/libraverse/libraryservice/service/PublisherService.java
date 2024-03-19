package com.libraverse.libraryservice.service;

import com.libraverse.libraryservice.entity.Publisher;
import com.libraverse.libraryservice.models.publisher.PublisherUpdateRequest;

import java.util.List;

public interface PublisherService {

    Publisher findById(Long publisher_id);
    Publisher save(Publisher publisher);
    List<Publisher> findAll();
    Publisher update(Long publisher_id, PublisherUpdateRequest updateModel);
    void delete(Long publisher_id);
}
