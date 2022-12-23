package com.service.factration.web;
import com.service.factration.entite.facture;
import com.service.factration.feign.ProduitItemRestClient;
import com.service.factration.feign.clientRestClient;
import com.service.factration.model.Client;
import com.service.factration.model.Produit;
import com.service.factration.repository.factureRepository;
import com.service.factration.repository.produitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class factureRestController {


    private factureRepository factureRepository;
    private produitRepository produitRepository;
    private clientRestClient clientRestClient;
    private ProduitItemRestClient produitItemRestClient;

    public factureRestController(com.service.factration.repository.factureRepository factureRepository, com.service.factration.repository.produitRepository produitRepository, com.service.factration.feign.clientRestClient clientRestClient, ProduitItemRestClient produitItemRestClient) {
        this.factureRepository = factureRepository;
        this.produitRepository = produitRepository;
        this.clientRestClient = clientRestClient;
        this.produitItemRestClient = produitItemRestClient;
    }

    @GetMapping(path = "/allfacture/{id}")
    public facture GetFactur(@PathVariable(name = "id") Long id){
        facture fact=factureRepository.findById(id).get();
        Client client=clientRestClient.getClientById(fact.getClientId());
        fact.setFacture(fact.getId());
        fact.setClient(client);
        fact.getProduitItems().forEach(p->{
            Produit produit=produitItemRestClient.getProduitByID(p.getProduitID());
            p.setProduit(produit);
        });
        return fact;
    }

}
