package org.advent.day4;

import java.util.ArrayList;
import java.util.List;

public class ScratchCard {
    List<String> winningNumbers;
    List<String> myNumbers;
    int[] pointTable = new int[]{0,1,2,4,8,16,32,64,128,256,512};

    public ScratchCard() {
        winningNumbers=new ArrayList<>();
        myNumbers=new ArrayList<>();
    }

    public ScratchCard(String cardString) throws Exception {
        this();
        if(cardString!=null && !cardString.isBlank()) {
            String main = cardString.substring(cardString.indexOf(":")+1);
            String[] winLoss = main.split("\\|");

            if(winLoss==null||winLoss.length!=2)
                throw new Exception("Invalid card string!");
            
            for(String s: winLoss[0].trim().split("\\s"))
                if(!s.isBlank())
                    winningNumbers.add(s);
            for(String s: winLoss[1].trim().split("\\s"))
                if(!s.isBlank())
                    myNumbers.add(s);
        }
    }

    public List<String> myWinners() {
        ArrayList<String> winners = new ArrayList<>();
        for(String s: myNumbers)
            if(winningNumbers.contains(s))
                winners.add(s);
        return winners;
    }

    public int points() {
        return this.pointTable[myWinners().size()];
    }
}
