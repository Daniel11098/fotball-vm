package no.vm2026.fotball_vm.core.ports.out;

import no.vm2026.fotball_vm.core.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findByStatus(String status);



    List<Match> findByKickOffTimeBetweenAndTournamentTournamentType(LocalDateTime start, LocalDateTime end,
                                                                            TournamentType tournament);
    Match findByMatchId(int matchId);

    @Query("SELECT m.manOfTheMatch FROM Match m WHERE m.matchId = :matchId")
    Optional<Player> findManOfTheMatchByMatchId(@Param("matchId") int matchId);

    List<Match> findByTournamentTournamentType(TournamentType tournament);

}
