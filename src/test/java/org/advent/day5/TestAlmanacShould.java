package org.advent.day5;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.junit.jupiter.api.Test;

public class TestAlmanacShould {
    @Test
    void should_be_empty_when_created() {
        Almanac almanac = new Almanac();
        assertThat(almanac.maps, isNotNull());
        assertThat(almanac.maps.size(), equalTo(0));
    }

    @Test
    void should_store_multiple_maps() {
        Almanac almanac = new Almanac();

        almanac.addMap("seed-to-soil", "50 98 2");
        assertThat(almanac.maps.size(), equalTo(1));

        almanac.addMap("soil-to-fertilizer", "0 15 37");
        assertThat(almanac.maps.size(), equalTo(3));

        almanac.addMap("fertilizer-to-water", "49 53 8");
        assertThat(almanac.maps.size(), equalTo(3));
    }

    @Test
    void should_take_one_step_in_almanac() {
        Almanac almanac = new Almanac();

        almanac.addMap("seed-to-soil", "50 98 2");
        assertThat(almanac.getDestinationValue("seed", "soil", 1), equalTo(1));
        assertThat(almanac.getDestinationValue("seed", "soil", 98), equalTo(50));
        // handles mapping that is not stored
        assertThat(almanac.getDestinationValue("soil", "fertilizer", 1), lessThan(0));
    }

    @Test
    void should_take_multiple_steps_in_almanac_starting_at_seeds() {
        Almanac almanac = new Almanac();

        almanac.addMap("seed-to-soil", "50 98 2");
        almanac.addMap("soil-to-fertilizer", "0 15 37");
        almanac.addMap("fertilizer-to-water", "1 30 8");

        assertThat(almanac.getDestinationValue("seed", "fertilizer", 1), equalTo(1));
        assertThat(almanac.getDestinationValue("seed", "fertilizer", 98), equalTo(35));
        assertThat(almanac.getDestinationValue("seed", "water", 1), equalTo(1));
        assertThat(almanac.getDestinationValue("seed", "water", 98), equalTo(6));
    }
}
