package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.api.controller.dto.MatchResponseMapper;
import no.vm2026.fotball_vm.api.controller.dto.MatchesResponseDTO;
import no.vm2026.fotball_vm.api.external.ApiFootballService;
import no.vm2026.fotball_vm.api.external.MatchSyncService;
import no.vm2026.fotball_vm.api.controller.dto.MatchListDTO;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesWrapperDTO;
import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.Matches;
import no.vm2026.fotball_vm.core.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("api/nationalmatches")
public class NationalMatchController {
    private final ApiFootballService apiFootballService;
    private final Matches nationalMatches;
    private final MatchSyncService matchSyncService;
    private final MatchService matchService;
    private final MatchResponseMapper matchResponseMapper;

    public NationalMatchController(ApiFootballService apiFootballService,
                                   Matches nationalMatches, MatchSyncService matchSyncService,
                                   MatchService matchService, MatchResponseMapper matchResponseMapper){
        this.nationalMatches = nationalMatches;
        this.apiFootballService = apiFootballService;
        this.matchSyncService = matchSyncService;
        this.matchService = matchService;
        this.matchResponseMapper = matchResponseMapper;
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
    public MatchListDTO getYesterdaysWcNationalMatches(){
        matchSyncService.syncYesterdaysMatches();
        List<Match> matches = matchService.getAllYesterdayTeamMatches();
        List<MatchesResponseDTO> responseDTOs = matches.stream()
                .map(match -> matchResponseMapper.toResponseDTO(match))
                .collect(Collectors.toList());
        return new MatchListDTO(responseDTOs);
    }

    @GetMapping("wc/tomorrow")
    public NationalMatchesWrapperDTO getTomorrowsWcNationalMatches(){
        return apiFootballService.fetchTomorrowsWorldCupMatches();
    }
}
