package org.advent.day4;

import java.util.ArrayList;
import java.util.List;

public class ScratchCard {
    List<Integer> winningNumbers;
    List<Integer> myNumbers;

    public ScratchCard() {
        winningNumbers=new ArrayList<>();
        myNumbers=new ArrayList<>();
    }

    public ScratchCard(String cardString) {
        this();
        //not implemented
    }

    public List<Integer> myWinners() {
        return null;//not implemented
    }
    
    public int points() {
        return 0;// not implemented
    }
}
