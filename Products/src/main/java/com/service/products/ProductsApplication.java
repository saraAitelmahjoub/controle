package com.service.products;

import com.service.products.entitie.produit;
import com.service.products.repository.produitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(produitRepository produitrepo, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(new Class[]{produit.class});
        return (args) -> {
            produitrepo.save(new produit((Long)null, "ordinateur", 2000.0, 2.0));
            produitrepo.save(new produit((Long)null, "telephone", 7270.0, 2.0));
            produitrepo.save(new produit((Long)null, "ordinateur", 5000.0, 2.0));
        };
    }
}
