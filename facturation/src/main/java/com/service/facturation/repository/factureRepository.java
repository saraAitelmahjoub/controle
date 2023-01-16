package com.service.facturation.repository;

import com.service.facturation.entite.facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface factureRepository extends JpaRepository<facture,Long> {

    @RestResource(path = "/byClientId")
    List<facture> findByClientId(@Param("clientId") Long clientId);

    @RestResource(path = "/byfactureId")
    facture findByFacture(@Param("factureId") Long facture);
}
