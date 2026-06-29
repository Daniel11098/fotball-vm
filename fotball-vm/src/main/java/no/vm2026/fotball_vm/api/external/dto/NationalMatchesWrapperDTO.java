package no.vm2026.fotball_vm.api.external.dto;

import lombok.Data;

import java.util.List;

@Data
public class NationalMatchesWrapperDTO {
    //MatchesWrapperDTO = døren inn til listen!
    //"currentMatchday":3,"winner":null},"id":537423
    private List<NationalMatchesResponsDTO> matches;
}
