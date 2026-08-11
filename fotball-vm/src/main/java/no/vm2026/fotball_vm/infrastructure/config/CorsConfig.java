package no.vm2026.fotball_vm.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Konfigurerer CORS (Cross-Origin Resource Sharing) for applikasjonen.
 *
 * Uten denne klassen ville nettleseren blokkere alle forespørsler fra
 * React-frontenden (localhost:3000) til Spring Boot-backenden (localhost:8080).
 * Dette er fordi nettleseren har en innebygd sikkerhetsregel kalt Same-Origin Policy
 * som blokkerer kommunikasjon mellom forskjellige porter/domener.
 *
 * Denne klassen forteller Spring Boot:
 * - Hvem får snakke med oss: localhost:3000 (React under utvikling)
 * - Hvilke HTTP-metoder er tillatt: GET, POST, PUT, DELETE
 * - Hvilke headers er tillatt: alle (*)
 *
 * VIKTIG: I produksjon bør allowedOrigins endres fra localhost:3000
 * til det faktiske domenenavnet til frontenden din (f.eks. https://1143-vm.no)
 */



@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("Content-Type\", \"Authorization\", \"X-Auth-Token");
            }
        };

    }

}
