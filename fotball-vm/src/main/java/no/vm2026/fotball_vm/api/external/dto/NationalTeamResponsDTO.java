package no.vm2026.fotball_vm.api.external.dto;

import lombok.Data;

@Data
public class NationalTeamResponsDTO {
    //"homeTeam":{"id":818,"name":"Colombia","shortName":"Colombia","tla":"COL","crest":"https://crests.football-data.org/818.svg"}
    //"awayTeam":{"id":1934,"name":"Congo DR","shortName":"Congo DR","tla":"COD","crest":"https://crests.football-data.org/congo_dr.svg"},
    protected int id;
    protected String name;
    protected String tla;
    protected String crest;
}

