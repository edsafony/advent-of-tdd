package org.advent.day4;

public class CardPile {
    public static void main(String[] args) {
        String fileName = "resources/puzzleinput.txt";
        try {
            CardCopyGame game = new CardCopyGame(fileName);
            System.out.println(String.format(
                    "There are a total of %d points in this %d card pile!", game.cards.size(), game.getTotalPoints()));
            System.out.println(String.format(
                    "After copying the original %d cards, there are a total number of %d cards", game.cards.size(),
                    game.countCopies()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
