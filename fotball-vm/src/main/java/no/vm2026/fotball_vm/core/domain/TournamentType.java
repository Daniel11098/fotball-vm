package no.vm2026.fotball_vm.core.domain;

public enum TournamentType {
    WORLD_CUP("FIFA World Cup"),
    EURO("UEFA European Championship"),
    COPA_AMERICA("Copa America"),
    NATIONS_LEAGUE("UEFA Nations League"),

    PREMIER_LEAGUE("Premier League"),
    LA_LIGA("La Liga"),
    BUNDESLIGA("Bundesliga"),
    SERIE_A("Serie A"),
    LIGUE_1("Ligue 1"),

    SAUDI_PRO_LEAGUE("Saudi Pro League"),
    MLS("Major League Soccer"),

    CHAMPIONS_LEAGUE("UEFA Champions League"),
    EUROPA_LEAGUE("UEFA Europa League"),
    CONFERENCE_LEAGUE("UEFA Conference League");

    private final String displayName;

    TournamentType(String displayName){
        this.displayName = displayName;
    }

    public String getDisPlayName(){
        return displayName;
    }
}
