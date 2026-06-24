package no.vm2026.fotball_vm.api.external;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Service
public class ApiFootballService {
    private final WebClient webClient;

    public ApiFootballService(WebClient webClient){
        this.webClient = webClient;
    }

    public String  fetchTodaysWorlCupMatches(){
        LocalDate today = LocalDate.now();
        return webClient.get() //Send en Get forespøsel
                //.uri("/competitions/2000/matches?"+ "dateFrom?"+ today + "dateTo?" + today) // til dette endepunktet
                .uri(uriBuilder -> uriBuilder
                        .path("/competitions/2000/matches")
                        .queryParam("dateFrom", today)
                        .queryParam("dateTo", today)
                        .build())
                .retrieve()//hent responsen
                .bodyToMono(String.class) //konverter til tekst
                .block(); //Vente på svar (synkonisert)
    }

    public String fetchYesterdayWorldCupMatches(){
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/competitions/2000/matches")
                        .queryParam("dateFrom", yesterday)
                        .queryParam("dateTo", yesterday)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String fetchTomorrowsWorldCupMatches(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/competitions/2000/matches")
                        .queryParam("dateFrom", tomorrow)
                        .queryParam("dateTo", tomorrow)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
