package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.api.external.ApiFootballService;
import no.vm2026.fotball_vm.api.external.dto.NationalMatchesWrapperDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ApiFootballService apiFootballService;

    public TestController(ApiFootballService apiFootballService) {
        this.apiFootballService = apiFootballService;
    }

    @GetMapping("/test")
    public NationalMatchesWrapperDTO test() {
        return apiFootballService.fetchTodaysWorlCupMatches();
    }
}