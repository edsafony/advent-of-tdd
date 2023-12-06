package org.advent.day5;

import java.util.Map;
import java.util.TreeMap;

public class AlmanacMap {
    String sourceName, destinationName;
    private Map<Integer, int[]> map;

    public AlmanacMap() {
        this.map = new TreeMap<>();
    }

    public AlmanacMap(String source, String destination) {
        this();
        this.sourceName=source;
        this.destinationName=destination;
    }

    public AlmanacMap(String sourceAndDestination) {
        this(sourceAndDestination.split("-to-")[0], sourceAndDestination.split("-to-")[1]);
    }

    public void addMapping(int source, int destination, int range) {
        //check if this range is overriding an existing mapping (cannot do this right now!)
        map.put(source, new int[]{destination,range});
    }

    public int getNumberOfMappings() {
        return map.size();
    }
    
    public int mapDestination(int sourceValue) {
        int[] destination;
        if((destination = getNearestValidSourceMapping(sourceValue))!=null) {
            int storedSource = destination[0];
            int storedDestintation = destination[1];
            int range = destination[2];

            if((storedSource+range)<=sourceValue) {//we're in range
                return (storedDestintation-storedSource) + sourceValue;
            }
        }
        return sourceValue;
    }

    public boolean isSourceInRange(int sourceValue) {
        return getNearestValidSourceMapping(sourceValue) != null;
    }

    /**
     * Get the source-to-destination mapping closest to sourceValue or NULL
     * 
     * @param sourceValue
     * @return
     */
    private int[] getNearestValidSourceMapping(int sourceValue) {
        int[] prevMapValue=null;
        int prevSource=-1;

        for(int source : map.keySet()) {
            if(source>sourceValue)
                break;
            prevSource = source;
            prevMapValue = map.get(source);
        }

        if(prevMapValue!=null && (sourceValue>=prevSource && sourceValue <= prevSource+prevMapValue[1]-1))
            return new int[]{prevSource, prevMapValue[0], prevMapValue[1]};
            
        return null;
    }
}
