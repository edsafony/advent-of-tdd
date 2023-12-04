package org.advent.day4;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CardPile {
    public static void main(String[] args) {
        String fileName = "src/main/java/org/advent/day4/resources/puzzleinput.txt";
        int totalPoints=0;
        String line="";
        ScratchCard card;

        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(fileName));

            while((line=reader.readLine())!=null) {
                card = new ScratchCard(line);
                totalPoints += card.points();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(String.format("There are a total of %d points in this card pile!", totalPoints));
    }
}
