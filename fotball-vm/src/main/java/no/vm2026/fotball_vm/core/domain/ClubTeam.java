package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table (name = "ClubTeam")
public class ClubTeam extends Team {
    protected String venue;
    @OneToMany(mappedBy = "correntClub")
    protected List<Player> players;
    public ClubTeam(int teamId, String name, int matchesPlayed,
                    int goalScored, int code, List<Player> players) {
        super(teamId, name, matchesPlayed, goalScored, code);
        this.players=players;
    }
    public ClubTeam(int teamId, String name, int matchesPlayed,
                    int goalScored, int code, String venue, List<Player> players) {
        super(teamId, name, matchesPlayed, goalScored, code);
        this.venue = venue;
        this.players = players;
    }
    public ClubTeam(){}
}
