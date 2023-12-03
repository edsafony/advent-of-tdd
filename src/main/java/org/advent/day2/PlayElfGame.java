package org.advent.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayElfGame {
    public static void main(String[] args) {
        int maxRed = 12, maxGreen = 13, maxBlue = 14, sumOfValidGames = 0, totalPowerSum=0, totalGames=0;
        String gameLine; int[] minCubesNeeded;
        CubeGameRound gameRound = new CubeGameRound();

        try {
            BufferedReader reader = Files.newBufferedReader(
                    Path.of("src/main/java/org/advent/day2/resources/realinput.txt"));
            
            while((gameLine=reader.readLine())!= null && !gameLine.isBlank()) {
                totalGames++;
                gameRound.init(gameLine);
                if(gameRound.isThisGameValid(maxRed, maxGreen, maxBlue)) {
                    sumOfValidGames += gameRound.getGameId();
                }

                minCubesNeeded = gameRound.getMinimumColorsNeeded();
                totalPowerSum += (minCubesNeeded[0]*minCubesNeeded[1]*minCubesNeeded[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(String.format(
            "The sum of the valid game IDs is %d when max red, green & blue are %d, %d & %d"
            , sumOfValidGames, maxRed, maxGreen, maxBlue));
        System.out.println(String.format("The power sum for all %d games is %d.",totalGames, totalPowerSum));
    }
}
