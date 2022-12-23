package com.service.factration.repository;

import com.service.factration.entite.produitItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface produitRepository extends JpaRepository<produitItem,Long> {
        public Collection<produitItem> findByFactureId(Long id);
}
