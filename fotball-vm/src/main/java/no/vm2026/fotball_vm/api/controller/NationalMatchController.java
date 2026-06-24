package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.api.external.ApiFootballService;
import no.vm2026.fotball_vm.core.domain.NatonalMatch;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.NationalMatches;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/nationalmatches")
public class NationalMatchController {
    private final ApiFootballService apiFootballService;
    private final NationalMatches nationalMatches;

    public NationalMatchController(ApiFootballService apiFootballService,NationalMatches nationalMatches){
        this.nationalMatches = nationalMatches;
        this.apiFootballService = apiFootballService;
    }

    @GetMapping
    public List<NatonalMatch> getTodaysNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllTodaysNationalTeamMatches(tournament);
    }

    @GetMapping("/yesterday")
    public List<NatonalMatch> getYesterdaysNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllYesterdayNationalTeamMatches(tournament);
    }

    @GetMapping("/tomorrow")
    public List<NatonalMatch> getTomorrowsNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllTomorrowNationalTeamMatches(tournament);
    }

    @GetMapping("wc/today")
    public String getTodaysWcNationalMatches(){
        return apiFootballService.fetchTodaysWorlCupMatches();
    }

    @GetMapping("wc/yesterday")
    public String getYesterdaysWcNationalMatches(){
        return apiFootballService.fetchYesterdayWorldCupMatches();
    }

    @GetMapping("wc/tomorrow")
    public String getTomorrowsWcNationalMatches(){
        return apiFootballService.fetchTomorrowsWorldCupMatches();
    }
}
