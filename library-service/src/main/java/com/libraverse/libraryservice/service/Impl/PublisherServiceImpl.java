package com.libraverse.libraryservice.service.Impl;

import com.libraverse.libraryservice.entity.Publisher;
import com.libraverse.libraryservice.models.publisher.PublisherUpdateRequest;
import com.libraverse.libraryservice.repository.PublisherRepository;
import com.libraverse.libraryservice.service.PublisherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public Publisher findById(Long publisher_id) {
        Assert.notNull(publisher_id, "Publisher id cannot be null");
        return publisherRepository.findById(publisher_id)
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found with id: " + publisher_id));
    }

    @Override
    public Publisher save(Publisher publisher) {
        return null;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher update(Long publisher_id, PublisherUpdateRequest updateModel) {
        return null;
    }

    @Override
    public void delete(Long publisher_id) {
        publisherRepository.deleteById(publisher_id);
    }
}
