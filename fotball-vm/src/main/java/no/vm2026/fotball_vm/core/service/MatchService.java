package no.vm2026.fotball_vm.core.service;

import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.Matches;
import no.vm2026.fotball_vm.core.ports.out.MatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService implements Matches {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }


    @Override
    public List<Match> getAllTodaysTeamMatches(TournamentType tournament) {
        LocalDate today = LocalDate.now();

        LocalDateTime startOfTheDay = today.atStartOfDay();
        LocalDateTime endOfTheDay = today.plusDays(1).atStartOfDay();

        List<Match> todaysMatches= matchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return todaysMatches;
    }

    @Override
    public List<Match> getAllTomorrowTeamMatches(TournamentType tournament) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        LocalDateTime startOfTheDay= tomorrow.atStartOfDay();
        LocalDateTime endOfTheDay = tomorrow.plusDays(1).atStartOfDay();

        List<Match> tomorrowsMatches= matchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return tomorrowsMatches;
    }

    @Override
    public List<Match> getAllYesterdayTeamMatches(TournamentType tournament) {
        LocalDate yesterday = LocalDate.now().minusDays(1);

        LocalDateTime startOfTheDay = yesterday.atStartOfDay();
        LocalDateTime endOfTheDay = yesterday.plusDays(1).atStartOfDay();

        List<Match> yesterdaysMatches = matchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return yesterdaysMatches;
    }

    @Override
    public List<Match> getAllYesterdayTeamMatches() {
        return matchRepository.findByStatus("FINISHED");
    }
}