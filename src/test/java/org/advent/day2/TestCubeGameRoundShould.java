package org.advent.day2;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestCubeGameRoundShould {
    
    @Test
    void should_read_game_id() {
        CubeGameRound gameRound = new CubeGameRound();
        gameRound.init("Game 1: 3 blue");

        assertThat(gameRound.getGameId(), equalTo(1));
    }

    @Test
    void should_detect_number_of_sets() {
        CubeGameRound gameRound = new CubeGameRound();
        gameRound.init("Game 1: 3 blue");

        assertThat(gameRound.getNumberOfSets(), equalTo(1));

        gameRound.init("Game 1: 3 blue; 2 green");
        assertThat(gameRound.getNumberOfSets(), equalTo(2));

        gameRound.init("Game 1: ");
        assertThat(gameRound.getNumberOfSets(), equalTo(0));

        gameRound.init("Game 1: 0 blue; 0 green");
        assertThat(gameRound.getNumberOfSets(), equalTo(2));
    }

    @Test
    void should_detect_valid_game() {
        CubeGameRound gameRound = new CubeGameRound();
        gameRound.init("Game 1: 3 blue");

        assertTrue(gameRound.isThisGameValid(0,  0, 4));

        gameRound.init("Game 1: 3 blue; 2 green");
        assertTrue(gameRound.isThisGameValid(0,  2, 4));

        gameRound.init("Game 1: ");
        assertTrue(gameRound.isThisGameValid(1,  1, 4));

        gameRound.init("Game 1: 4 blue; 10 green, 3 red");
        assertTrue(gameRound.isThisGameValid(3,  10, 4));
        assertTrue(gameRound.isThisGameValid(5,  20, 4));
    }

    @Test
    void should_detect_invalid_game() {
        CubeGameRound gameRound = new CubeGameRound();
        gameRound.init("Game 1: 3 blue");

        assertFalse(gameRound.isThisGameValid(0,  0, 2));
        assertFalse(gameRound.isThisGameValid(0,  -1, 2));

        gameRound.init("Game 1: 3 blue; 2 green");
        assertFalse(gameRound.isThisGameValid(0,  1, 4));
        assertFalse(gameRound.isThisGameValid(0,  4, 1));

        gameRound.init("Game 1: 4 blue; 10 green, 3 red");
        assertFalse(gameRound.isThisGameValid(3,  9, 4));
        assertFalse(gameRound.isThisGameValid(0,  0, 0));
    }

    @Test
    void should_return_three_minimum_numbers() {
        CubeGameRound gameRound = new CubeGameRound();

        gameRound.init("Game 1: 4 blue; 10 green, 3 red");
        assertThat(gameRound.getMinimumColorsNeeded().length, equalTo(3));

        gameRound.init("Game 1: 4 red; 10 green, 3 red");
        assertThat(gameRound.getMinimumColorsNeeded().length, equalTo(3));
    }

    @Test
    void should_find_correct_minimums() {
        CubeGameRound gameRound = new CubeGameRound();

        gameRound.init("Game 1: 4 blue; 10 green, 3 red");
        assertArrayEquals(new int[]{3,10,4}, gameRound.getMinimumColorsNeeded());

        gameRound.init("Game 1: 4 blue, 15 red, 2 green; 10 green, 3 red, 1 blue");
        assertArrayEquals(new int[]{15,10,4}, gameRound.getMinimumColorsNeeded());

        gameRound.init("Game 1: 4 blue, 23 red; 1 green, 3 red, 5 blue");
        assertArrayEquals(new int[]{23,1,5}, gameRound.getMinimumColorsNeeded());
    }
}
