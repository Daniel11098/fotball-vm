package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.api.external.ApiFootballService;
import no.vm2026.fotball_vm.api.external.MatchSyncService;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesResponsDTO;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesWrapperDTO;
import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.Matches;
import no.vm2026.fotball_vm.core.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/nationalmatches")
public class NationalMatchController {
    private final ApiFootballService apiFootballService;
    private final Matches nationalMatches;
    private final MatchSyncService matchSyncService;
    private final MatchService matchService;

    public NationalMatchController(ApiFootballService apiFootballService,
                                   Matches nationalMatches, MatchSyncService matchSyncService,
                                   MatchService matchService){
        this.nationalMatches = nationalMatches;
        this.apiFootballService = apiFootballService;
        this.matchSyncService = matchSyncService;
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getTodaysNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllTodaysTeamMatches(tournament);
    }

    @GetMapping("/yesterday")
    public List<Match> getYesterdaysNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllYesterdayTeamMatches(tournament);
    }

    @GetMapping("/tomorrow")
    public List<Match> getTomorrowsNationalMatches(@RequestParam TournamentType tournament){
        return nationalMatches.getAllTomorrowTeamMatches(tournament);
    }

    @GetMapping("wc/today")
    public NationalMatchesWrapperDTO getTodaysWcNationalMatches(){
        return apiFootballService.fetchTodaysWorlCupMatches();
    }

    @GetMapping("wc/yesterday")
    public List<Match> getYesterdaysWcNationalMatches(){
        matchSyncService.syncYesterdaysMatches();
        return matchService.getAllYesterdayTeamMatches();
    }

    @GetMapping("wc/tomorrow")
    public NationalMatchesWrapperDTO getTomorrowsWcNationalMatches(){
        return apiFootballService.fetchTomorrowsWorldCupMatches();
    }
}
