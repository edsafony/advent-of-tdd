package org.advent.day5;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class TestAlmanacMapShould {
    @Test
    void should_be_created_with_source_and_destination_names() {

        AlmanacMap mapper = new AlmanacMap();

        assertThat(mapper.sourceName, isEmptyOrNullString());
        assertThat(mapper.destinationName, isEmptyOrNullString());
        assertThat(mapper.getNumberOfMappings(), equalTo(0));

        mapper = new AlmanacMap("seed-to-soil");
        assertThat(mapper.sourceName, equalTo("seed"));
        assertThat(mapper.destinationName, equalTo("soil"));
        assertThat(mapper.getNumberOfMappings(), equalTo(0));

        mapper = new AlmanacMap("seed","soil");
        assertThat(mapper.sourceName, equalTo("seed"));
        assertThat(mapper.destinationName, equalTo("soil"));
        assertThat(mapper.getNumberOfMappings(), equalTo(0));
    }
    
    @Test
    void should_have_correct_ranges_when_created() {
        AlmanacMap mapper = new AlmanacMap();

        mapper.addMapping(98, 50, 2);
        assertThat(mapper.getNumberOfMappings(), equalTo(1));
        assertThat(mapper.isSourceInRange(98), equalTo(true));
        assertThat(mapper.isSourceInRange(99), equalTo(true));
        assertThat(mapper.isSourceInRange(100), equalTo(false));
        assertThat(mapper.isSourceInRange(0), equalTo(false));
        assertThat(mapper.isSourceInRange(200), equalTo(false));

        mapper.addMapping(50, 52, 48);
        assertThat(mapper.getNumberOfMappings(), equalTo(2));
        assertThat(mapper.isSourceInRange(50), equalTo(true));
        assertThat(mapper.isSourceInRange(60), equalTo(true));
        assertThat(mapper.isSourceInRange(75), equalTo(true));
        assertThat(mapper.isSourceInRange(0), equalTo(false));
        assertThat(mapper.isSourceInRange(200), equalTo(false));
    }

    @Test
    void should_map_source_to_destination() {
        AlmanacMap mapper = new AlmanacMap();

        mapper.addMapping(98, 50, 2);
        assertThat(mapper.mapDestination(98), equalTo(50));
        assertThat(mapper.mapDestination(99), equalTo(51));
        assertThat(mapper.mapDestination(100), equalTo(100));
        assertThat(mapper.mapDestination(1), equalTo(1));
        assertThat(mapper.mapDestination(50), equalTo(50));

        mapper.addMapping(50, 52, 48);
        assertThat(mapper.mapDestination(50), equalTo(52));
        assertThat(mapper.mapDestination(75), equalTo(77));
        assertThat(mapper.mapDestination(97), equalTo(99));
        assertThat(mapper.mapDestination(98), equalTo(50));
        assertThat(mapper.mapDestination(99), equalTo(51));
    }
}
