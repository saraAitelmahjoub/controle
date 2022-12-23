package com.service.factration.feign;

import com.service.factration.model.Produit;
import jakarta.ws.rs.QueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitItemRestClient {
    // PagedModel<Produit> pageProduits(@QueryParam(value="page") int page,
    //                                @QueryParam(value="size")  int size);

    @GetMapping(path = "/produits")
    PagedModel<Produit> pageProduits();

    @GetMapping(path = "/produits/{id}")
    Produit getProduitByID(@PathVariable Long id);
}

