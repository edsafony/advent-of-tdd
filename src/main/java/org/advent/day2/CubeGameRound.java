package org.advent.day2;

import java.util.HashSet;
import java.util.Set;

public class CubeGameRound {

    private int gameId;
    Set<BagGrab> grabSets;

    public CubeGameRound() {
        grabSets = new HashSet<>();
    }

    protected void setGameId(String gameId) {
        if(gameId!=null && gameId.length()>5)
            this.gameId = Integer.parseInt(gameId.substring(5));
    }

    public void init(String gameString) {

        if(gameString==null || gameString.isEmpty())
            return;

        this.grabSets.clear();
        String[] game1 = gameString.split(":");
        setGameId(game1[0]);

        if(game1.length==1 || game1[1].isBlank())
            return;

        for(String cubeSet : game1[1].split(";")) {
            this.grabSets.add(BagGrab.build(cubeSet));
        }
    }

    public int getGameId() {
        return this.gameId;
    }

    public int getNumberOfSets() {
        return this.grabSets.size();
    }
    
    public boolean isThisGameValid(int maxRed, int maxGreen, int maxBlue) {
        for(BagGrab grab : this.grabSets) {
            if(grab.getNumberOfCubesByColor("red")>maxRed
            || grab.getNumberOfCubesByColor("green")>maxGreen
            || grab.getNumberOfCubesByColor("blue")>maxBlue)
                return false;
        }
        return true;
    }
}
