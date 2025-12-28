package com.ismaildrs.conferenceservice;

import com.ismaildrs.conferenceservice.entities.Conference;
import com.ismaildrs.conferenceservice.entities.Review;
import com.ismaildrs.conferenceservice.repositories.ConferenceRepository;
import com.ismaildrs.conferenceservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

        public static void main(String[] args) {
                SpringApplication.run(ConferenceServiceApplication.class, args);
        }

        @Bean
        public org.springframework.web.filter.CorsFilter corsFilter() {
                org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.setAllowedOrigins(java.util.Collections.singletonList("http://localhost:4200"));
                corsConfiguration.setAllowedHeaders(
                                java.util.Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                                                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                                                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
                corsConfiguration.setExposedHeaders(
                                java.util.Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                                                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
                                                "Access-Control-Allow-Credentials"));
                corsConfiguration.setAllowedMethods(java.util.Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                org.springframework.web.cors.UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
                urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
                return new org.springframework.web.filter.CorsFilter(urlBasedCorsConfigurationSource);
        }

        @Bean
        CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository,
                        ReviewRepository reviewRepository) {
                return args -> {
                        Conference conf1 = Conference.builder()
                                        .titre("Big Data & AI")
                                        .type("Académique")
                                        .date(new Date())
                                        .duree(3.0)
                                        .nombreInscrits(150)
                                        .score(4.5)
                                        .keynoteId(1L)
                                        .build();

                        Conference conf2 = Conference.builder()
                                        .titre("Microservices Architecture")
                                        .type("Commerciale")
                                        .date(new Date())
                                        .duree(2.5)
                                        .nombreInscrits(200)
                                        .score(4.8)
                                        .build();

                        conferenceRepository.save(conf1);
                        conferenceRepository.save(conf2);

                        reviewRepository.save(Review.builder()
                                        .date(new Date())
                                        .texte("Excellent presentation!")
                                        .stars(5)
                                        .conference(conf1)
                                        .build());

                        reviewRepository.save(Review.builder()
                                        .date(new Date())
                                        .texte("Very informative.")
                                        .stars(4)
                                        .conference(conf1)
                                        .build());

                        reviewRepository.save(Review.builder()
                                        .date(new Date())
                                        .texte("Great insights on microservices.")
                                        .stars(5)
                                        .conference(conf2)
                                        .build());
                };
        }
}
