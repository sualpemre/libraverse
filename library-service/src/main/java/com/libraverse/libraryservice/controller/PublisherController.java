package com.libraverse.libraryservice.controller;


import com.libraverse.libraryservice.dto.PublisherDto;
import com.libraverse.libraryservice.entity.Publisher;
import com.libraverse.libraryservice.models.publisher.PublisherUpdateRequest;
import com.libraverse.libraryservice.service.PublisherService;
import com.libraverse.libraryservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publisher")
@RequiredArgsConstructor
public class PublisherController {


    private final PublisherService publisherService;
    @GetMapping("/{publisher_id}")
    public ResponseEntity<PublisherDto> get(@PathVariable Long publisher_id){
        Publisher publisher = publisherService.findById(publisher_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(publisher, PublisherDto.class));
    }

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAll(){
        List<Publisher> publishers = publisherService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(publishers, PublisherDto.class));
    }

    @PatchMapping("/{publisher_id}/update")
    public ResponseEntity<PublisherDto> update(@PathVariable Long publisher_id, @RequestBody PublisherUpdateRequest updateModel){
        Publisher genre = publisherService.update(publisher_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(genre, PublisherDto.class));
    }

    @DeleteMapping("/{publisher_id}/delete")
    public void delete(@PathVariable Long publisher_id){
        publisherService.delete(publisher_id);
    }
}
