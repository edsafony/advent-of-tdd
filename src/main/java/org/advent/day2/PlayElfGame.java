package org.advent.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayElfGame {
    public static void main(String[] args) {
        int maxRed = 12, maxGreen = 13, maxBlue = 14, totalGames = 0;
        String gameLine;
        CubeGameRound gameRound = new CubeGameRound();

        try {
            BufferedReader reader = Files.newBufferedReader(
                    Path.of("src/main/java/org/advent/day2/resources/realinput.txt"));
            
            while((gameLine=reader.readLine())!= null && !gameLine.isBlank()) {
                gameRound.init(gameLine);
                if(gameRound.isThisGameValid(maxRed, maxGreen, maxBlue)) {
                    totalGames += gameRound.getGameId();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(String.format(
            "The sum of the valid game IDs is %d when max red, green & blue are %d, %d & %d"
            , totalGames, maxRed, maxGreen, maxBlue));
    }
}
