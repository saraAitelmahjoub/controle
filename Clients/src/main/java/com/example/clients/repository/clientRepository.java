package com.example.clients.repository;

import com.example.clients.entities.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface clientRepository extends JpaRepository<client, Long> {
}
