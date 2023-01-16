package com.service.facturation;

import com.service.facturation.entite.facture;
import com.service.facturation.entite.produitItem;
import com.service.facturation.feign.ProduitItemRestClient;
import com.service.facturation.feign.clientRestClient;
import com.service.facturation.model.Client;
import com.service.facturation.model.Produit;
import com.service.facturation.repository.produitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;
import com.service.facturation.repository.factureRepository;
@SpringBootApplication
@EnableFeignClients
public class FacturationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturationApplication.class, args);
    }
    @Bean
    CommandLineRunner start(factureRepository factureRepository, produitRepository produitRepository, clientRestClient restClient, ProduitItemRestClient produitItemRestClient )
    {
        return args -> {
   Client client=restClient.getClientById(3L);
            facture fct= factureRepository.save(new facture(null,new Date(),null,null,client.getID(),null));
            fct.setFacture(fct.getId());
            factureRepository.save(fct);
            System.out.println(fct);
            PagedModel<Produit> produitPagedModel=produitItemRestClient.pageProduits();

            produitPagedModel.forEach(p->{
               produitItem proditem=new produitItem();
                proditem.setPrix(p.getPrix());
                proditem.setQuantite(1+new Random().nextInt(100));
                proditem.setFacture(fct);
                proditem.setProduitID(p.getId());
                produitRepository.save(proditem);
            });

          Client client2=restClient.getClientById(2L);
            facture fct2= factureRepository.save(new facture(null,new Date(),null,null,client2.getID(),null));
            fct2.setFacture(fct2.getId());
            factureRepository.save(fct2);
            System.out.println(fct2);
            PagedModel<Produit>  produitPagedModel2=produitItemRestClient.pageProduits();

            produitPagedModel2.forEach(p->{
               produitItem proditem=new produitItem();
                proditem.setPrix(p.getPrix());
                proditem.setQuantite(1+new Random().nextInt(100));
                proditem.setFacture(fct2);
                proditem.setProduitID(p.getId());
                produitRepository.save(proditem);
            });
           Client client1=restClient.getClientById(1L);
            facture fct1= factureRepository.save(new facture(null,new Date(),null,null,client1.getID(),null));
            fct1.setFacture(fct1.getId());
            factureRepository.save(fct1);
            System.out.println(fct1);
            PagedModel<Produit>  produitPagedModel1=produitItemRestClient.pageProduits();

            produitPagedModel1.forEach(p->{
                produitItem proditem=new produitItem();
                proditem.setPrix(p.getPrix());
                proditem.setQuantite(1+new Random().nextInt(100));
                proditem.setFacture(fct1);
                proditem.setProduitID(p.getId());
                produitRepository.save(proditem);
            });

            System.out.println("-----------------");
            System.out.println("ID: "+client1.getID());
            System.out.println("name: "+client1.getName());
            System.out.println("Email: "+ client1.getEmail());
        };
    }
}
