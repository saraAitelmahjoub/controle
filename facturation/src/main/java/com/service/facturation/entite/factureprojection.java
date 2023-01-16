package com.service.facturation.entite;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="allFactures",types = facture.class)
public interface factureprojection {
    Long getId();
    Date getDateFacture();
    Long getClientId();

}
