package no.vm2026.fotball_vm.api.external;

import no.vm2026.fotball_vm.api.external.ApiFootballService;
import no.vm2026.fotball_vm.api.external.MatchMapper;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesResponsDTO;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesWrapperDTO;
import no.vm2026.fotball_vm.core.domain.Match;
import no.vm2026.fotball_vm.core.ports.out.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchSyncService {

    private final ApiFootballService apiFootballService;
    private final MatchMapper matchMapper;
    private final MatchRepository matchRepository;

    public MatchSyncService(ApiFootballService apiFootballService,
                            MatchMapper matchMapper,
                            MatchRepository matchRepository) {
        this.apiFootballService = apiFootballService;
        this.matchMapper = matchMapper;
        this.matchRepository = matchRepository;
    }

    public void syncYesterdaysMatches() {
        // 1. Hent fra API
        List<NationalMatchesResponsDTO> nationalMatches = apiFootballService.fetchYesterdayWorldCupMatches().getMatches();
        // 2. Oversett hver kamp
        for (NationalMatchesResponsDTO matches : nationalMatches){
            Match matchs = matchMapper.toMatch(matches);
            // 3. Lagre i database
            matchRepository.save(matchs);
        }
    }
}