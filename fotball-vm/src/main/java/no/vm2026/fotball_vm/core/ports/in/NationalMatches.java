package no.vm2026.fotball_vm.core.ports.in;

import no.vm2026.fotball_vm.core.domain.NatonalMatch;
import no.vm2026.fotball_vm.core.domain.TournamentType;

import java.util.List;

public interface NationalMatches {
    List<NatonalMatch> getAllTodaysNationalTeamMatches(TournamentType tournament);
    List<NatonalMatch> getAllTomorrowNationalTeamMatches(TournamentType tournament);
    List<NatonalMatch> getAllYesterdayNationalTeamMatches(TournamentType tournament);
}
