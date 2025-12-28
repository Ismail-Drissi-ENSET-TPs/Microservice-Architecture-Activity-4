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
    public org.springframework.web.filter.CorsFilter corsFilter() {
        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(java.util.Collections.singletonList("http://localhost:4200"));
        corsConfiguration
                .setAllowedHeaders(java.util.Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                        "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                        "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(java.util.Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(java.util.Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        org.springframework.web.cors.UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new org.springframework.web.filter.CorsFilter(urlBasedCorsConfigurationSource);
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
