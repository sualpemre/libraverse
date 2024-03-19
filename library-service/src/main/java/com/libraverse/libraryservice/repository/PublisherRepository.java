package com.libraverse.libraryservice.repository;

import com.libraverse.libraryservice.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}