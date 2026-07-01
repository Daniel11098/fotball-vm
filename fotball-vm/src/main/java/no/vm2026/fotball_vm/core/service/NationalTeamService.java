package no.vm2026.fotball_vm.core.service;

import no.vm2026.fotball_vm.core.domain.NationalTeam;
import no.vm2026.fotball_vm.core.ports.in.NationalTeams;
import no.vm2026.fotball_vm.core.ports.out.NationalTeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationalTeamService implements NationalTeams {
    private final NationalTeamRepository nationalTeamRepository;

    public NationalTeamService(NationalTeamRepository nationalTeamRepository){
        this.nationalTeamRepository=nationalTeamRepository;
    }

    @Override
    public NationalTeam findOrCreat(int teamId, String name, String tla) {
        return nationalTeamRepository.findById(teamId).orElseGet(() -> {
            NationalTeam newTeam = new NationalTeam();
            newTeam.setTeamId(teamId);
            newTeam.setName(name);
            newTeam.setTla(tla);
            return nationalTeamRepository.save(newTeam);
        });
    }

    @Override
    public NationalTeam save(NationalTeam team) {
        return nationalTeamRepository.save(team);
    }
}
