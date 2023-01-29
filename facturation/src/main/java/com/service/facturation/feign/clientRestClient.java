package com.service.facturation.feign;
import com.service.facturation.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@FeignClient(name="CLIENT-SERVICE")
public interface clientRestClient {

    @GetMapping(path = "/clients/{id}")
    Client getClientById(@PathVariable(name = "id") Long id);
   @GetMapping(path = "/clients")
    Client getAllClient();
}
