package com.sample.demo.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FootballTeamTest {

    private static final int THREE_GAMES_WON = 3;
    private static final int ANY_NUMBER = 1;

    @Test
    void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(THREE_GAMES_WON);

        assertThat(team.getGamesWon())
            .as("number of games won")
            .isEqualTo(THREE_GAMES_WON);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 10})
    void constructorShouldSetGamesWon(int noOfGamesWon) {
        FootballTeam team = new FootballTeam(noOfGamesWon);

        assertThat(team.getGamesWon())
                .as("number of games won")
                .isEqualTo(noOfGamesWon);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNoOfGamesWon) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new FootballTeam(illegalNoOfGamesWon));
    }

    @Test
    void shouldBePossibleToCompareTeams() {
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertThat(team).isInstanceOf(Comparable.class);
    }

    @Test
    void teamsWithMoreMatchesWonShouldBeGreater() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertThat(team_3.compareTo(team_2)).isGreaterThan(0);
    }

    @Test
    void teamsWithLessMatchesWonShouldBeLesser() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertThat(team_2.compareTo(team_3)).isLessThan(0);
    }

    @Test
    void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(2);

        assertThat(teamA.compareTo(teamB)).isEqualTo(0);
    }
}
