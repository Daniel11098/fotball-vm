package no.vm2026.fotball_vm.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Konfigurerer HTTP-klienten som brukes for å hente data fra football-data.org API.
 *
 * Denne klassen lager en WebClient bean som er tilgjengelig for hele applikasjonen
 * via Dependency Injection. ApiFootballService injiserer denne WebClient-instansen
 * og bruker den til å sende HTTP GET-forespørsler til football-data.org.
 *
 * WebClient er konfigurert med:
 * - baseUrl: Adressen til football-data.org API (https://api.football-data.org/v4)
 * - X-Auth-Token header: API-nøkkelen som autentiserer oss mot football-data.org
 *
 * API-nøkkelen hentes fra miljøvariabelen FOOTBALL_DATA_KEY via application.yaml
 * og injiseres via @Value — nøkkelen er aldri hardkodet i koden!
 *
 * Siden dette er en @Bean vil Spring Boot lage én instans ved oppstart og
 * gjenbruke den overalt — ingen ny tilkobling opprettes for hver forespørsel.
 */

@Configuration
public class WebClientConfig {
    @Value("${api-football.key}")
    private String apiValue;

    @Value("${api-football.base-url}")
    private String baseUrl;

    @Bean
    public WebClient apiFootballWebCleint(){
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Auth-Token", apiValue)
                .build();
    }

}
