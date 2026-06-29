package no.vm2026.fotball_vm.api.external;


import no.vm2026.fotball_vm.api.external.dto.FullTimeDTO;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesResponsDTO;
import no.vm2026.fotball_vm.api.external.dto.ScoreDTO;
import no.vm2026.fotball_vm.core.domain.Match;
import org.springframework.data.domain.Score;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MatchMapper {

    public Match toMatch(NationalMatchesResponsDTO dto){
        Match match = new Match();
        match.setMatchId(dto.getId());
        match.setStatus(dto.getStatus());
        match.setStage(dto.getStage());
        match.setKickOffTime(
                LocalDateTime.parse(dto.getUtcDate(),
                    DateTimeFormatter.ISO_DATE_TIME)
        );

        if (dto.getScore() != null && dto.getScore().getFullTime() != null){
            match.setHomeTeamScore(dto.getScore().getFullTime().getHome());
            match.setAwayTeamScore(dto.getScore().getFullTime().getAway());
        }
        return match;
    }
}
