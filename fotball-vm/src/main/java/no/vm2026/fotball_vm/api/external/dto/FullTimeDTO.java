package no.vm2026.fotball_vm.api.external.dto;

import lombok.Data;

@Data
public class FullTimeDTO {
    private Integer home;  // Integer — kan være null!
    private Integer away;
}
