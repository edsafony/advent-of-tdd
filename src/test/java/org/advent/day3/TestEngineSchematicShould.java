package org.advent.day3;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestEngineSchematicShould {
    
    @Test
    void should_be_empty_when_created() {
        EngineSchematic engine = new EngineSchematic();
        assertThat(engine.size(), equalTo(0));
    }

    @Test
    void should_load_correct_number_of_rows() {
        EngineSchematic engine = new EngineSchematic();
        engine.addSchemaRow(0, ".....2.");
        assertThat(engine.size(), equalTo(1));
    }

    @Test
    void should_read_input_from_file() throws IOException {
        EngineSchematic engine = new EngineSchematic("resources/testinput.txt");
        assertTrue(engine.size()>0);
    }

    @Test
    void should_find_valid_symbols() {
        EngineSchematic engine = new EngineSchematic();
        engine.addSchemaRow(0, ".*..2..#..@...");
        assertFalse(engine.isValidSymbol(0, 0));
        assertTrue(engine.isValidSymbol(0, 7));
        assertTrue(engine.isValidSymbol(0, 10));
        assertFalse(engine.isValidSymbol(0, 4));
    }

    @Test
    void should_find_all_numbers_in_a_line() {
        EngineSchematic engine = new EngineSchematic();
        engine.addSchemaRow(0, "..2.4..101.");
        assertNull(engine.getNumber(0, 0));
        assertNull(engine.getNumber(0, 1));
        assertThat(engine.getNumber(0, 2), equalTo(2));
        assertThat(engine.getNumber(0, 4), equalTo(4));
        assertThat(engine.getNumber(0, 7), equalTo(101));
    }

    @Test
    void should_identify_valid_part_numbers() {
        EngineSchematic engine = new EngineSchematic();
        engine.addSchemaRow(0, "..*4..101.");
        assertTrue(engine.isPartNumber(0, 3));
        assertFalse(engine.isPartNumber(0, 6));
        assertFalse(engine.isPartNumber(0, 0));

        //add rows above & below
        engine = new EngineSchematic();
        engine.addSchemaRow(0, "..*4..101.");
        engine.addSchemaRow(1, "..16.2...*");
        engine.addSchemaRow(2, ".........7");
        assertTrue(engine.isPartNumber(1, 2));//16 is valid
        assertFalse(engine.isPartNumber(1, 5));//2 invalid
        assertTrue(engine.isPartNumber(0, 6));//101 is now valid
        assertTrue(engine.isPartNumber(2, 9));//7 is valid
    }

    @Test
    void should_add_all_valid_part_numbers() {
        EngineSchematic engine = new EngineSchematic();
        engine.addSchemaRow(0, "..*4..101.");
        assertThat(engine.getSumAllParts(), equalTo(4));

        //add rows above & below
        engine = new EngineSchematic();
        engine.addSchemaRow(0, "..*4..101.");
        engine.addSchemaRow(1, "..16.2...*");
        engine.addSchemaRow(2, ".........7");
        assertThat(engine.getSumAllParts(), equalTo(128));
        engine.addSchemaRow(3, ".....9....");
        assertThat(engine.getSumAllParts(), equalTo(128));
    }
}
