package org.advent.day4;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestScratchCardShould {
    @Test
    void should_be_empty_when_crated() {
        ScratchCard card = new ScratchCard();
        assertNotNull(card.myNumbers);
        assertThat(card.myNumbers.size(), equalTo(0));

        assertNotNull(card.winningNumbers);
        assertThat(card.winningNumbers.size(), equalTo(0));
    }

    @Test
    void should_read_card_string() throws Exception {
        ScratchCard card = new ScratchCard("Card 1: 41 | 83 86");

        assertThat(card.myNumbers.size(), equalTo(2));
        assertThat(card.winningNumbers.size(), equalTo(1));

        card = new ScratchCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        assertThat(card.myNumbers.size(), equalTo(8));
        assertThat(card.winningNumbers.size(), equalTo(5));
    }

    @Test
    void should_find_zero_winning_number() throws Exception {
        ScratchCard card = new ScratchCard("Card 1: 2 | 83 86  6 31 17  9 48 53");

        assertThat(card.myWinners().size(), equalTo(0));
        
        card = new ScratchCard("Card 1: 41 48 83 86 17 | 1");

        assertThat(card.myWinners().size(), equalTo(0));
    }

    @Test
    void should_find_single_winning_number() throws Exception {
        ScratchCard card = new ScratchCard("Card 1: 86 | 83 86  6 31 17  9 48 53");

        assertThat(card.myWinners().get(0), equalTo("86"));
        
        card = new ScratchCard("Card 1: 41 48 83 86 1 | 1 99");

        assertThat(card.myWinners().get(0), equalTo("1"));
    }

    @Test
    void should_find_multiple_winning_numbers() throws Exception {
        ScratchCard card = new ScratchCard("Card 1: 86 53 | 83 86  6 31 17  9 48 53");

        assertThat(card.myWinners().containsAll(Arrays.asList(new String[]{"86", "53"})), equalTo(true));
        
        card = new ScratchCard("Card 1: 41 48 83 86 1 | 1 99 83 48");

        assertThat(card.myWinners().containsAll(Arrays.asList(new String[]{"1", "83", "48"})), equalTo(true));
    }

    @Test
    void should_calculate_points_for_multiple_winners() throws Exception {
        ScratchCard card = new ScratchCard("Card 1: 86 | 83 86  6 31 17  9 48 53");

        assertThat(card.points(), equalTo(1));
        
        card = new ScratchCard("Card 1: 41 48 83 86 1 | 1 99 41");

        assertThat(card.points(), equalTo(2));

        card = new ScratchCard("Card 1: 41 48 83 86 1 | 1 99 41 56 86");

        assertThat(card.points(), equalTo(4));

        card = new ScratchCard("Card 1: 41 48 83 86 1 | 99 99 99 99");

        assertThat(card.points(), equalTo(0));
    }
}
