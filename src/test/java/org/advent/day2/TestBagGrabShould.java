package org.advent.day2;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class TestBagGrabShould {

    @Test
    void should_be_empty_when_created() {
        BagGrab grab = new BagGrab();
        assertThat(grab.getNumberOfColors(), equalTo(0));
    }

    @Test
    void should_have_one_cube() {
        BagGrab grab = BagGrab.build("3 red");

        assertThat(grab.getNumberOfColors(), equalTo(1));
        assertThat(grab.getNumberOfCubesByColor("red"), equalTo(3));
    }

    @Test
    void should_build_class_from_color_string() {
        BagGrab grab = BagGrab.build("3 red, 5 blue");

        assertThat(grab.getNumberOfColors(), equalTo(2));
        assertThat(grab.getNumberOfCubesByColor("red"), equalTo(3));
        assertThat(grab.getNumberOfCubesByColor("blue"), equalTo(5));

        grab = BagGrab.build("1 red, 54 blue, 10 green");
        assertThat(grab.getNumberOfCubesByColor("red"), equalTo(1));
        assertThat(grab.getNumberOfCubesByColor("blue"), equalTo(54));
        assertThat(grab.getNumberOfCubesByColor("green"), equalTo(10));
    }

    @Test
    void should_handle_invalid_inputs() {
        BagGrab grab = BagGrab.build("0 red, 0 blue, 0 green");

        assertThat(grab.getNumberOfColors(), equalTo(0));

        grab = BagGrab.build("-1 blue, 10 green, 0 red");

        assertThat(grab.getNumberOfColors(), equalTo(1));
        assertThat(grab.getNumberOfCubesByColor("blue"), equalTo(0));
        assertThat(grab.getNumberOfCubesByColor("green"), equalTo(10));
    }
}
