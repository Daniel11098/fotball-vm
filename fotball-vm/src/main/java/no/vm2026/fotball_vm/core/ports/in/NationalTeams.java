package no.vm2026.fotball_vm.core.ports.in;


import no.vm2026.fotball_vm.core.domain.NationalTeam;

import java.util.Optional;

public interface NationalTeams {
    NationalTeam findOrCreat(int teamId, String name, String tla);
    NationalTeam save(NationalTeam team);
}
