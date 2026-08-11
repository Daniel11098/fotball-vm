package no.vm2026.fotball_vm.api.controller.dto;

import lombok.Data;
import no.vm2026.fotball_vm.core.domain.Match;

import java.util.List;
@Data
public class MatchListDTO {
    private List<MatchesResponseDTO> matches;

    public MatchListDTO(List<MatchesResponseDTO> matches) {
        this.matches = matches;
    }

    public List<MatchesResponseDTO> getMatches() {
        return matches;
    }
}
