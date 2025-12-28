package com.ismaildrs.keynoteservice;

import com.ismaildrs.keynoteservice.entities.Keynote;
import com.ismaildrs.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository) {
        return args -> {
            keynoteRepository.save(Keynote.builder()
                    .nom("Hassan")
                    .prenom("Mohamed")
                    .email("hassan.mohamed@example.com")
                    .fonction("Software Engineer")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .nom("Drissi")
                    .prenom("Ismail")
                    .email("ismail.drissi@example.com")
                    .fonction("Architect")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .nom("Alaoui")
                    .prenom("Fatima")
                    .email("fatima.alaoui@example.com")
                    .fonction("Data Scientist")
                    .build());
        };
    }
}
