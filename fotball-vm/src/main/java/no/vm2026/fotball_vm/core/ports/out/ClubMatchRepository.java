package no.vm2026.fotball_vm.core.ports.out;

import no.vm2026.fotball_vm.core.domain.ClubMatch;
import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.Player;
import no.vm2026.fotball_vm.core.domain.TournamentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClubMatchRepository extends JpaRepository<ClubMatch, Integer> {

    List<ClubMatch> findByKickOffTimeBetweenAndTournamentTournamentType(LocalDateTime start, LocalDateTime end,
                                                                        TournamentType tournament);
    Match findByMatchId(int matchId);

    @Query("SELECT m.manOfTheMatch FROM Match m WHERE m.matchId = :matchId")
    Optional<Player> findManOfTheMatchByMatchId(@Param("matchId") int matchId);

    List<ClubMatch> findByTournamentTournamentType(TournamentType tournament);
}
