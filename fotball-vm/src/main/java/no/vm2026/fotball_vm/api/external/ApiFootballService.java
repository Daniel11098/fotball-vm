package no.vm2026.fotball_vm.api.external;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiFootballService {
    private final WebClient webClient;

    public ApiFootballService(WebClient webClient){
        this.webClient = webClient;
    }

    public String  fetchWorlCupMatches(){
        return webClient.get() //Send en Get forespøsel
                .uri("/matches") // til dette endepunktet
                .retrieve()//hent responsen
                .bodyToMono(String.class) //konverter til tekst
                .block(); //Vente på svar (synkonisert)
    }
}
