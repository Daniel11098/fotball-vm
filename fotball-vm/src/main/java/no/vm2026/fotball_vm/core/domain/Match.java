package no.vm2026.fotball_vm.core.domain;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Entity
@Table(name = "Match")
public  class Match{
    @Id
    @GeneratedValue
    protected int matchId;

    @ManyToOne
    protected Team homeTeam;
    @ManyToOne
    protected Team awayTeam;
    protected int homeTeamScore;
    protected int awayTeamScore;
    @Nullable
    @ManyToMany
    @JoinTable(
            name = "home_starting_eleven",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "Player_id")
    )
    protected List<Player> homeStartingEleven;

    @Nullable
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
    protected String status;  // "FINISHED", "TIMED", "IN_PLAY"
    protected String stage;   // "GROUP_STAGE", "LAST_32" osv

    @Nullable
    @ManyToOne
    protected Player manOfTheMatch;

    @Nullable
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
        this.homeTeamScore = teamOneScore;
        this.awayTeamScore = teamTwoScore;
        this.tournament = tournament;
        this.kickOffTime = kickOffTime;
        this.manOfTheMatch = manOfTheMatch;
        this.card = card;
    }

    public Match(int matchId, Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore,
                 Tournament tournament, LocalDateTime kickOffTime, String status, String stage) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.tournament = tournament;
        this.kickOffTime = kickOffTime;
        this.status = status;
        this.stage = stage;
    }

    public Match(){}

}
