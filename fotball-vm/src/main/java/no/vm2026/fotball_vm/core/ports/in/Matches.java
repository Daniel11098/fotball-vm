package no.vm2026.fotball_vm.core.ports.in;

import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.TournamentType;

import java.util.List;

public interface Matches {
    List<Match> getAllTodaysTeamMatches(TournamentType tournament);
    List<Match> getAllTomorrowTeamMatches(TournamentType tournament);
    List<Match> getAllYesterdayTeamMatches(TournamentType tournament);
    List<Match> getAllYesterdayTeamMatches();
}
