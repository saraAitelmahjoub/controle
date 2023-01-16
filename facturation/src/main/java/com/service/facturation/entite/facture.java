package com.service.facturation.entite;

import com.service.facturation.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@ToString
public class facture {
    public facture(Long id, Date dateFacture, Collection<com.service.facturation.entite.produitItem> produitItems, Long produitID, Long clientId, Client clients) {
        this.id = id;
        this.dateFacture = dateFacture;
        this.produitItems = produitItems;
        this.produitID = produitID;
        this.client=clients;
        this.clientId = clientId;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long facture;
    private Date dateFacture;
    @OneToMany(mappedBy = "facture")
    private Collection <produitItem> produitItems;

    private Long produitID;
    private Long clientId;
    @Transient
    private Client client;

    public double getTotal(){
        double s=0;
        for(produitItem p:produitItems){
            s+=p.getPrix()*p.getQuantite();
        }
        return s;
    }
}
