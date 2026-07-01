package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "ClubTeam")
public class ClubTeam extends Team {
    protected String venue;
    @OneToMany(mappedBy = "currentClub")
    protected List<Player> players;


    public ClubTeam(){}
}
