package no.vm2026.fotball_vm.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "nationalTeams")
public class NationalTeam extends Team{
    @OneToMany(mappedBy = "nationalTeam")
    protected List<Player> players;


    public NationalTeam(){}
}
