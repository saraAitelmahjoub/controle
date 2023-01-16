package com.example.clients;

import com.example.clients.entities.client;
import com.example.clients.repository.clientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(clientRepository clientrep, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(new Class[]{client.class});
        return (args) -> {
            clientrep.save(new client(1L, "sara", "sara@gmail.com"));
            clientrep.save(new client(2L, "salah", "salah@gmail.com"));
            clientrep.save(new client(3L, "younes", "younes@gmail.com"));
            clientrep.findAll().forEach((c) -> {
                System.out.println(c.toString());
            });
        };
    }
}
