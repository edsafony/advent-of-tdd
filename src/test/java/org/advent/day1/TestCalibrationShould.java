package org.advent.day1;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class TestCalibrationShould {
    @Test
    void should_have_zero_combined_value_when_created() {

        Calibration calibration = new Calibration();
        assertThat(calibration.getCalibrationValue(), equalTo(0));
    }

    @Test
    void should_find_the_correct_first_digit() {
        Calibration calibration = new Calibration("1");
        assertThat(calibration.getFirstDigit(), equalTo(1));

        calibration.setCalibrationValue("1kfgp");
        assertThat(calibration.getFirstDigit(), equalTo(1));

        calibration.setCalibrationValue("af1lk5p");
        assertThat(calibration.getFirstDigit(), equalTo(1));
    }

    @Test
    void should_find_the_corret_last_value() {
        Calibration calibration = new Calibration("1");
        assertThat(calibration.getLastDigit(), equalTo(1));

        calibration.setCalibrationValue("1kfgp");
        assertThat(calibration.getLastDigit(), equalTo(1));

        calibration.setCalibrationValue("af1lk5p");
        assertThat(calibration.getLastDigit(), equalTo(5));

        calibration.setCalibrationValue("af15p");
        assertThat(calibration.getLastDigit(), equalTo(5));

        calibration.setCalibrationValue("af15plks8sd");
        assertThat(calibration.getLastDigit(), equalTo(8));

        calibration.setCalibrationValue("af15p0df");
        assertThat(calibration.getLastDigit(), equalTo(0));

    }

    @Test
    void should_be_same_first_and_last_when_only_one_number() {
        Calibration calibration = new Calibration("1");
        assertThat(calibration.getFirstDigit(), equalTo(calibration.getLastDigit()));

        calibration.setCalibrationValue("1kfgp");
        assertThat(calibration.getFirstDigit(), equalTo(calibration.getLastDigit()));

        calibration.setCalibrationValue("jsd1kfgp");
        assertThat(calibration.getFirstDigit(), equalTo(calibration.getLastDigit()));
    }

    @Test
    void should_have_combined_value_equal_to_first_and_last_concatenated() {
        Calibration calibration = new Calibration("1kd2");
        assertThat(calibration.getCalibrationValue(), equalTo(12));

        calibration.setCalibrationValue("af1lk5p");
        assertThat(calibration.getCalibrationValue(), equalTo(15));

        calibration.setCalibrationValue("af15plks8sd");
        assertThat(calibration.getCalibrationValue(), equalTo(18));

        calibration.setCalibrationValue("af15p0df");
        assertThat(calibration.getCalibrationValue(), equalTo(10));

        calibration.setCalibrationValue("af05p9df");
        assertThat(calibration.getCalibrationValue(), equalTo(9));
    }
    
    @Test
    void should_handle_numbers_as_words(){
        Calibration calibration = new Calibration("one");
        assertThat(calibration.getFirstDigit(), equalTo(1));
        assertThat(calibration.getLastDigit(), equalTo(1));
        assertThat(calibration.getCalibrationValue(), equalTo(11));

        calibration.setCalibrationValue("2onekl3j7four");
        assertThat(calibration.getFirstDigit(), equalTo(2));
        assertThat(calibration.getLastDigit(), equalTo(4));
        assertThat(calibration.getCalibrationValue(), equalTo(24));

        calibration.setCalibrationValue("zerone8lkdsfjtwenty6fivelkdf");
        assertThat(calibration.getFirstDigit(),equalTo(0));
        assertThat(calibration.getLastDigit(), equalTo(5));
        assertThat(calibration.getCalibrationValue(), equalTo(5));

        calibration.setCalibrationValue("bbsqsix6");
        assertThat(calibration.getFirstDigit(),equalTo(6));
        assertThat(calibration.getLastDigit(), equalTo(6));
        assertThat(calibration.getCalibrationValue(), equalTo(66));

        calibration.setCalibrationValue("1sixhvsclvhshbr");
        assertThat(calibration.getFirstDigit(),equalTo(1));
        assertThat(calibration.getLastDigit(), equalTo(6));
        assertThat(calibration.getCalibrationValue(), equalTo(16));

        calibration.setCalibrationValue("two41sevenseventhreeone1seven");
        assertThat(calibration.getFirstDigit(),equalTo(2));
        assertThat(calibration.getLastDigit(), equalTo(7));
        assertThat(calibration.getCalibrationValue(), equalTo(27));

        calibration.setCalibrationValue("lmfgxfdsevenchrkbhxlrrssbcqqf7fivectglcvrsrg8");
        assertThat(calibration.getFirstDigit(),equalTo(7));
        assertThat(calibration.getLastDigit(), equalTo(8));
        assertThat(calibration.getCalibrationValue(), equalTo(78));
    }
}
