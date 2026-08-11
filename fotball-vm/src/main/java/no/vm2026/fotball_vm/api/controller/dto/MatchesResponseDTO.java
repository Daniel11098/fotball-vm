package no.vm2026.fotball_vm.api.controller.dto;

import lombok.Data;

@Data
public class MatchesResponseDTO {
    private int id;
    private String utcDate;
    private String status;
    private String stage;
    private TeamResponseDTO homeTeam;
    private TeamResponseDTO awayTeam;
    private ScoreResponseDTO score;

}
