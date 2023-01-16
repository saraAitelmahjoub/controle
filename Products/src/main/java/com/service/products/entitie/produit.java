package com.service.products.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class produit {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nameproduit;
    private double prix;
    private double quantite;




    public produit(final Long id, final String nameproduit, final double prix, final double quantite) {
        this.id = id;
        this.nameproduit = nameproduit;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "produit(id=" + var10000 + ", nameproduit=" + this.getNameproduit() + ", prix=" + this.getPrix() + ", quantite=" + this.getQuantite() + ")";
    }
}
