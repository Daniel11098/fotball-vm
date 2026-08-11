package no.vm2026.fotball_vm.api.controller.dto;

import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.domain.Team;
import org.springframework.stereotype.Component;

@Component
public class MatchResponseMapper {

    public MatchesResponseDTO toResponseDTO(Match match) {
        MatchesResponseDTO dto = new MatchesResponseDTO();
        dto.setId(match.getMatchId());
        dto.setStatus(match.getStatus());
        dto.setStage(match.getStage());
        dto.setUtcDate(match.getKickOffTime().toString());
        dto.setHomeTeam(toTeamDTO(match.getHomeTeam()));
        dto.setAwayTeam(toTeamDTO(match.getAwayTeam()));

        ScoreResponseDTO score = new ScoreResponseDTO();
        FullTimeResponseDTO fullTime = new FullTimeResponseDTO();
        fullTime.setHome(match.getHomeTeamScore());
        fullTime.setAway(match.getAwayTeamScore());
        score.setFullTime(fullTime);
        dto.setScore(score);

        return dto;
    }

    private TeamResponseDTO toTeamDTO(Team team) {
        TeamResponseDTO dto = new TeamResponseDTO();
        dto.setId(team.getTeamId());
        dto.setName(team.getName());
        dto.setTla(team.getTla());
        dto.setCrest(team.getCrest());
        return dto;
    }
}