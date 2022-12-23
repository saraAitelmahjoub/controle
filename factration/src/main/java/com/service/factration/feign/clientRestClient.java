package com.service.factration.feign;
import com.service.factration.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENT-SERVICE")
public interface clientRestClient {
    @GetMapping(path = "/clients/{id}")
    Client getClientById(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/clients")
    Client getAllClient();
}
