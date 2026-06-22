package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tournaments")
public class Tournament {
    @Id
    protected int id;
    @Enumerated(EnumType.STRING)
    protected TournamentType tournamentType;
    @ManyToMany
    @JoinTable(
            name = "Teams_In_Tournaments",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    protected List<Team> teamsInTournament;

    public Tournament(){}
}
