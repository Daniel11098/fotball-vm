package no.vm2026.fotball_vm.api.external.dto;

import lombok.Data;

@Data
public class NationalMatchesResponsDTO {
/*
"currentMatchday":3,"winner":null},"id":537423,"utcDate":"2026-06-29T17:00:00Z","status":"TIMED","matchday":null,"stage":"LAST_32","group":null,"lastUpdated":"2026-06-29T05:20:12Z",
"homeTeam":{"id":764,"name":"Brazil","shortName":"Brazil","tla":"BRA","crest":"https://crests.football-data.org/764.svg"},
"awayTeam":{"id":766,"name":"Japan","shortName":"Japan","tla":"JPN","crest":"https://crests.football-data.org/766.svg"},
"score":{"winner":null,"duration":"REGULAR","fullTime":{"home":null,"away":null},"halfTime":{"home":null,"away":null}},"
 */
    private int id;              // ikke matchId
    private String utcDate;      // ikke matchStatus
    private String status;       // ikke matchStatus
    private NationalTeamResponsDTO homeTeam;  // ikke homeTeamName
    private NationalTeamResponsDTO awayTeam;  // ikke awayTeamName
    private String stage;
    private ScoreDTO score;
}
