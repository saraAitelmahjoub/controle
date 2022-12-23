package com.service.factration.entite;

import com.service.factration.model.Client;
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
    public facture(Long id,  Date dateFacture, Collection<produitItem> produitItems, Long produitID, Long clientId, Client client) {
        this.id = id;
        this.dateFacture = dateFacture;
        this.produitItems = produitItems;
        this.produitID = produitID;
        this.clientId = clientId;
        this.client = client;
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
