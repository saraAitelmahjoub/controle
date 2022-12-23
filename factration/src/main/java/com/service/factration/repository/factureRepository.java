package com.service.factration.repository;

import com.service.factration.entite.facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface factureRepository extends JpaRepository<facture,Long> {

    @RestResource(path = "/byClientId")
    List<facture> findByClientId(@Param("clientId") Long clientId);

    @RestResource(path = "/byfactureId")
    facture findByFacture(@Param("factureId") Long facture);
}
