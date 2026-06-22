package no.vm2026.fotball_vm.core.service;

import no.vm2026.fotball_vm.core.domain.NationalTeam;
import no.vm2026.fotball_vm.core.domain.NatonalMatch;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.NationalTeams;
import no.vm2026.fotball_vm.core.ports.out.NationalMatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NationalMatchService implements NationalTeams {
    private final NationalMatchRepository nationalMatchRepository;

    public NationalMatchService(NationalMatchRepository nationalMatchRepository){
        this.nationalMatchRepository = nationalMatchRepository;
    }


    @Override
    public List<NatonalMatch> getAllTodaysNationalTeamMatches(TournamentType tournament) {
        LocalDate today = LocalDate.now();

        LocalDateTime startOfTheDay = today.atStartOfDay();
        LocalDateTime endOfTheDay = today.plusDays(1).atStartOfDay();

        List<NatonalMatch> todaysMatches= nationalMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return todaysMatches;
    }

    @Override
    public List<NatonalMatch> getAllTomorrowNationalTeamMatches(TournamentType tournament) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        LocalDateTime startOfTheDay= tomorrow.atStartOfDay();
        LocalDateTime endOfTheDay = tomorrow.plusDays(1).atStartOfDay();

        List<NatonalMatch> tomorrowsMatches= nationalMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return tomorrowsMatches;
    }

    @Override
    public List<NatonalMatch> getAllYesterdayNationalTeamMatches(TournamentType tournament) {
        LocalDate yesterday = LocalDate.now().minusDays(1);

        LocalDateTime startOfTheDay = yesterday.atStartOfDay();
        LocalDateTime endOfTheDay = yesterday.plusDays(1).atStartOfDay();

        List<NatonalMatch> yesterdaysMatches = nationalMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return yesterdaysMatches;
    }
}
