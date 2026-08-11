package no.vm2026.fotball_vm.api.controller.dto;
import lombok.Data;

@Data
public class TeamResponseDTO {
    private int id;
    private String name;
    private String tla;
    private String crest;
}