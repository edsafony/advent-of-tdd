package org.advent.day4;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class TestCardCopyGameShould {

    @Test
    void should_read_all_cards_when_created() {
        CardCopyGame copyGame = new CardCopyGame("resources/testinput.txt");
        assertThat(copyGame.cards.size(), equalTo(6));
        assertThat(copyGame.cardCounter.length, equalTo(copyGame.cards.size()));
    }

    @Test
    void should_count_correct_copies() {
        CardCopyGame copyGame = new CardCopyGame("resources/testinput.txt");
        assertThat(copyGame.countCopies(), equalTo(30));
    }
}
