package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TrebuchetController {
    public static void main(String[] args) {

        String calibrationLine="";
        int totalValue=0;

        try {
            BufferedReader reader = Files.newBufferedReader(
                Path.of("src/main/java/org/advent/day1/resources/realinput.txt"));

            Calibration calibration = new Calibration();
            while((calibrationLine=reader.readLine()) != null) {
                calibration.setCalibrationValue(calibrationLine);
                totalValue+=calibration.getCalibrationValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

            System.out.println("The total calibration value is "+totalValue);
    }
}
