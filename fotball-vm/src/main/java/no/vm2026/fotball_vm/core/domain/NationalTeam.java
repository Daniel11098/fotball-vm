package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table (name = "nationalTeams")
public class NationalTeam extends Team{
    @OneToMany(mappedBy = "nationalTeam")
    protected List<Player> players;

    public NationalTeam(int teamId, String name, int matchesPlayed,
                        int goalScored, int code, List<Player> players1) {
        super(teamId, name, matchesPlayed, goalScored, code);
        this.players = players1;
    }

    public NationalTeam(){}
}
