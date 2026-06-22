package no.vm2026.fotball_vm.core.domain;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name= "teams")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Team {
    @Id
    @GeneratedValue
    protected int teamId;
    protected String name;
    protected int matchesPlayed;
    protected int goalScored;
    protected int code;

    public Team(int teamId, String name, int matchesPlayed, int goalScored, int code) {
        this.teamId = teamId;
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.goalScored = goalScored;
        this.code = code;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public Team(){
    }
}
