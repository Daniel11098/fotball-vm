package no.vm2026.fotball_vm.core.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@Entity
@Table(name= "teams")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Team {
    @Id
    @GeneratedValue
    protected int teamId;
    protected String name;
    protected int matchesPlayed;
    protected int goalScored;
    protected int code;
    protected String tla;


    public Team(){
    }
}
