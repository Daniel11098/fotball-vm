package no.vm2026.fotball_vm.core.ports.in;

import no.vm2026.fotball_vm.core.domain.ClubMatch;
import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.TournamentType;

import java.util.List;

public interface ClubMatches {
    List<ClubMatch> getAllTodaysTeamMatches(TournamentType tournament);
    List<ClubMatch> getAllTomorrowTeamMatches(TournamentType tournament);
    List<ClubMatch> getAllYesterdayTeamMatches(TournamentType tournament);
}
