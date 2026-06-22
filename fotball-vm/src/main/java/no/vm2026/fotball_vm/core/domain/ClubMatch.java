package no.vm2026.fotball_vm.core.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table (name = "Club_Matches")
public class ClubMatch extends Match{
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    protected ClubTeam homeTeam;
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    protected ClubTeam awayTeam;
    @ManyToOne
    @JoinColumn(name = "team_one_id")
    @Nullable
    protected ClubTeam teamOne;
    @ManyToOne
    @JoinColumn(name = "team_two_id")
    @Nullable
    protected ClubTeam teamTwo;

    public ClubMatch(int matchId, int teamOneScore, int teamTwoScore, Tournament tournament, LocalDateTime kickOffTime,
                     Player manOfTheMatch, List<Player> card, ClubTeam homeTeam, ClubTeam awayTeam) {
        super(matchId, teamOneScore, teamTwoScore, tournament, kickOffTime, manOfTheMatch, card);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public ClubMatch(@Nullable ClubTeam teamOne, @Nullable ClubTeam teamTwo, int matchId, int teamOneScore, int teamTwoScore, Tournament tournament, LocalDateTime kickOffTime,
                     Player manOfTheMatch, List<Player> card) {
        super(matchId, teamOneScore, teamTwoScore, tournament, kickOffTime, manOfTheMatch, card);
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }


    public ClubMatch() {
    }
}
