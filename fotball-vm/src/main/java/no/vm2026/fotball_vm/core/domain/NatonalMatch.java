package no.vm2026.fotball_vm.core.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "NatonalMatch")
public class NatonalMatch extends Match{
    @ManyToOne
    @JoinColumn(name = "home_country_id")
    public NationalTeam homeCountry;
    @ManyToOne
    @JoinColumn(name = "away_country_id")
    public NationalTeam awayCountry;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "country_one_id")
    public NationalTeam countryOne;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "country_two_id")
    public NationalTeam countryTwo;
    public NatonalMatch() {
    }

    public NatonalMatch(int matchId, int teamOneScore, int teamTwoScore, Tournament tournament, LocalDateTime kickOffTime, Player manOfTheMatch,
                        List<Player> card, NationalTeam homeCountry, NationalTeam awayCountry) {
        super(matchId, teamOneScore, teamTwoScore, tournament, kickOffTime, manOfTheMatch, card);
        this.homeCountry = homeCountry;
        this.awayCountry = awayCountry;
    }

    public NatonalMatch(@Nullable NationalTeam countryOne,@Nullable NationalTeam countryTwo,int matchId, int teamOneScore, int teamTwoScore, Tournament tournament, LocalDateTime kickOffTime, Player manOfTheMatch,
                        List<Player> card) {
        super(matchId, teamOneScore, teamTwoScore, tournament, kickOffTime, manOfTheMatch, card);
        this.countryOne= countryOne;
        this.countryTwo= countryTwo;
    }
}
