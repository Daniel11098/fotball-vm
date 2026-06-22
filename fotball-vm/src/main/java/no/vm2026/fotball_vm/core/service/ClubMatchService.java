package no.vm2026.fotball_vm.core.service;

import no.vm2026.fotball_vm.core.domain.ClubMatch;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import no.vm2026.fotball_vm.core.ports.in.ClubMatches;
import no.vm2026.fotball_vm.core.ports.out.ClubMatchRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClubMatchService implements ClubMatches{

    private final ClubMatchRepository clubMatchRepository;

    public ClubMatchService(ClubMatchRepository clubMatchRepository) {
        this.clubMatchRepository = clubMatchRepository;
    }

    @Override
    public List<ClubMatch> getAllTodaysTeamMatches(TournamentType tournament) {
        LocalDate today = LocalDate.now();

        LocalDateTime startOfTheDay = today.atStartOfDay();
        LocalDateTime endOfTheDay = today.plusDays(1).atStartOfDay();

        List<ClubMatch> todaysMatches= clubMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return todaysMatches;
    }

    @Override
    public List<ClubMatch> getAllTomorrowTeamMatches(TournamentType tournament) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        LocalDateTime startOfTheDay= tomorrow.atStartOfDay();
        LocalDateTime endOfTheDay = tomorrow.plusDays(1).atStartOfDay();

        List<ClubMatch> tomorrowsMatches= clubMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return tomorrowsMatches;
    }


    @Override
    public List<ClubMatch> getAllYesterdayTeamMatches(TournamentType tournament){
        LocalDate yesterday = LocalDate.now().minusDays(1);

        LocalDateTime startOfTheDay = yesterday.atStartOfDay();
        LocalDateTime endOfTheDay = yesterday.plusDays(1).atStartOfDay();

        List<ClubMatch> yesterdaysMatches = clubMatchRepository.findByKickOffTimeBetweenAndTournamentTournamentType(startOfTheDay, endOfTheDay, tournament);

        return yesterdaysMatches;
    }

}
