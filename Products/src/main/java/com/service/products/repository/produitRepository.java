package com.service.products.repository;

import com.service.products.entitie.produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produitRepository extends JpaRepository<produit, Long> {
        }
