package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue
    protected int playerId;
    protected String name;
    protected int age;
    @ManyToOne
    @JoinColumn(name = "national_team_id")
    protected NationalTeam nationalTeam;
    @ManyToMany
    @JoinTable(
            name = "player_club_history",
            joinColumns = @JoinColumn(name = "PlayerId"),
            inverseJoinColumns = @JoinColumn(name = "TeamId")
    )
    protected List<ClubTeam> clubTeams;
    @ManyToOne
    @JoinColumn(name = "current_club_id")
    protected ClubTeam correntClub;
    protected int matchesPlayed;
    protected int goalscored;


    public Player(int playerId, String name, int age, NationalTeam nationalTeam,
                  List<ClubTeam> clubTeams, ClubTeam correntClub,
                  int matchesPlayed, int goalscored) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.nationalTeam = nationalTeam;
        this.clubTeams = clubTeams;
        this.correntClub = correntClub;
        this.matchesPlayed = matchesPlayed;
        this.goalscored = goalscored;
    }

    public Player(){

    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NationalTeam getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public List<ClubTeam> getClubTeams() {
        return clubTeams;
    }

    public void setClubTeams(List<ClubTeam> clubTeams) {
        this.clubTeams = clubTeams;
    }

    public ClubTeam getCorrentClub() {
        return correntClub;
    }

    public void setCorrentClub(ClubTeam correntClub) {
        this.correntClub = correntClub;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getGoalscored() {
        return goalscored;
    }

    public void setGoalscored(int goalscored) {
        this.goalscored = goalscored;
    }
}
