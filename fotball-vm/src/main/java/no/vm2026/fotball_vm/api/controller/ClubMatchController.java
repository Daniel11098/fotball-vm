package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.core.domain.ClubMatch;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.ClubMatches;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/clubmatches")
public class ClubMatchController {
    private final ClubMatches clubMatches;

    public ClubMatchController(ClubMatches clubMatches){
        this.clubMatches = clubMatches;
    }

    @GetMapping
    public List<ClubMatch> getTodaysMatches(@RequestParam TournamentType tournament){
        return clubMatches.getAllTodaysTeamMatches(tournament);
    }

    @GetMapping("/yesterday")
    public List<ClubMatch> getYesterdaysMatches(@RequestParam TournamentType tournament){
        return clubMatches.getAllYesterdayTeamMatches(tournament);
    }

    @GetMapping("/tomorrow")
    public List<ClubMatch> getTomorrowsMatches(@RequestParam TournamentType tournament){
        return clubMatches.getAllTomorrowTeamMatches(tournament);
    }



}
