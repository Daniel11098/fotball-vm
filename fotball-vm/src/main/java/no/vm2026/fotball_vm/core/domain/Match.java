package no.vm2026.fotball_vm.core.domain;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Entity
@Table(name = "Match")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Match{
    @Id
    @GeneratedValue
    protected int matchId;
    protected int teamOneScore;
    protected int teamTwoScore;
    @ManyToMany
    @JoinTable(
            name = "home_starting_eleven",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "Player_id")
    )
    protected List<Player> homeStartingEleven;
    @ManyToMany
    @JoinTable(
            name = "awayTeam_starting_eleven",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    protected List<Player> awayStartingEleven;
    @ManyToOne
    protected Tournament tournament;
    protected LocalDateTime kickOffTime;
    @ManyToOne
    protected Player manOfTheMatch;
    @ManyToMany
    @JoinTable(
            name = "Match_Players_Card",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "Player_id")
    )
    protected List<Player> card;

    public Match(int matchId,int teamOneScore, int teamTwoScore, Tournament tournament,
                 LocalDateTime kickOffTime, Player manOfTheMatch,
                 List<Player> card) {
        this.matchId = matchId;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.tournament = tournament;
        this.kickOffTime = kickOffTime;
        this.manOfTheMatch = manOfTheMatch;
        this.card = card;
    }


    public Match(){}

}
