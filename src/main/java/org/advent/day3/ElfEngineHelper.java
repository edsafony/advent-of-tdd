package org.advent.day3;

import java.io.IOException;

public class ElfEngineHelper {
    public static void main(String[] args) {
        try {
            EngineSchematic engineSchematic = new EngineSchematic("resources/puzzleinput.txt");
            System.out.println("The sum of valid part numbers is "+engineSchematic.getSumAllParts());
            System.out.println("The sum of all gear ratios is "+engineSchematic.getSumGearRatios());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
