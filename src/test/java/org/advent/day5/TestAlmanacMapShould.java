package org.advent.day5;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class TestAlmanacMapShould {
    @Test
    void should_have_correct_ranges_when_created() {
        AlmanacMap mapper = new AlmanacMap(50, 98, 2);

        assertThat(mapper.isDestinationInRange(50), equalTo(true));
        assertThat(mapper.isSourceInRange(98), equalTo(true));
    }
}
