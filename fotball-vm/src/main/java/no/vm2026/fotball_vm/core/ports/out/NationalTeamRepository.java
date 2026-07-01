package no.vm2026.fotball_vm.core.ports.out;

import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.NationalTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NationalTeamRepository extends JpaRepository<NationalTeam, Integer> {
    // Tomt! findById() og save() kommer gratis fra JpaRepository
}
