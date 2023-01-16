package com.service.facturation.entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.service.facturation.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class produitItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prix;
    private double quantite;
    private Long produitID;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    private facture facture;

    @Transient
    private Produit produit;
}
