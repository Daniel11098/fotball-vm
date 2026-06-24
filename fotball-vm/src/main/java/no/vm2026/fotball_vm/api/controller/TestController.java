package no.vm2026.fotball_vm.api.controller;

import no.vm2026.fotball_vm.api.external.ApiFootballService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ApiFootballService apiFootballService;

    public TestController(ApiFootballService apiFootballService) {
        this.apiFootballService = apiFootballService;
    }

    @GetMapping("/test")
    public String test() {
        return apiFootballService.fetchTodaysWorlCupMatches();
    }
}