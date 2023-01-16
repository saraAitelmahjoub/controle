package com.service.facturation.web;
import com.service.facturation.entite.facture;
import com.service.facturation.feign.ProduitItemRestClient;
import com.service.facturation.feign.clientRestClient;
import com.service.facturation.model.Client;
import com.service.facturation.model.Produit;
import com.service.facturation.repository.factureRepository;
import com.service.facturation.repository.produitRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class factureRestController {


    private factureRepository factureRepository;
    private produitRepository produitRepository;
    private clientRestClient clientRestClient;
    private ProduitItemRestClient produitItemRestClient;

    public factureRestController(factureRepository factureRepository, produitRepository produitRepository,clientRestClient clientRestClient, ProduitItemRestClient produitItemRestClient) {
        this.factureRepository = factureRepository;
        this.produitRepository = produitRepository;
        this.clientRestClient = clientRestClient;
        this.produitItemRestClient = produitItemRestClient;
    }
    @CrossOrigin(origins = "http://localhost:4200")
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
