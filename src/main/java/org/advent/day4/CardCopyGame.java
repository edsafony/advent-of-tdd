package org.advent.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CardCopyGame {
    List<ScratchCard> cards;
    List<Integer> cardCounter;

    public CardCopyGame(String fileName) throws IOException, Exception {
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        if (inputStream == null)
            throw new IllegalStateException("Unable to find file " + fileName);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));

        String line = "";
        this.cards = new ArrayList<>();
        this.cardCounter = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            this.cards.add(new ScratchCard(line));
            this.cardCounter.add(1);
        }
    }

    public int countCopies() {
        int numCopies = 0;

        for (int i = 0; i < this.cardCounter.size(); i++) {
            List<String> winners = this.cards.get(i).myWinners();
            for (int j = 1; j <= winners.size() && (i + j) < this.cardCounter.size(); j++) {
                this.cardCounter.set(i + j, this.cardCounter.get(i + j)+this.cardCounter.get(i));
            }
        }

        for (Integer count : this.cardCounter) {
            numCopies += count;
        }

        return numCopies;
    }

    public int getTotalPoints() {
        int sum=0;
        for(ScratchCard card: this.cards) {
            sum += card.points();
        }
        return sum;
    }
}
