package no.vm2026.fotball_vm.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

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
