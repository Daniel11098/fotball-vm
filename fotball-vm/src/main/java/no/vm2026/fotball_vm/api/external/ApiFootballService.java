package no.vm2026.fotball_vm.api.external;

import no.vm2026.fotball_vm.core.ports.in.NationalMatches;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ApiFootballService {
    private final WebClient webClient;

    public ApiFootballService(WebClient webClient){
        this.webClient = webClient;
    }

    public String  fetchWorlCupMatches(){
        return webClient.get() //Send en Get forespøsel
                .uri("/fixtures?league=1&season=2026") // til dette endepunktet
                .retrieve()//hent responsen
                .bodyToMono(String.class) //konverter til tekst
                .block(); //Vente på svar (synkonisert)
    }
}
