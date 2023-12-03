package org.advent.day2;

import java.util.HashMap;
import java.util.Map;

public class BagGrab {

    private Map<String, Integer> cubes;

    public BagGrab() {
        cubes = new HashMap<>();
    }

    public int getNumberOfCubesByColor(String cubeColor) {
        Integer numCubes = cubes.get(cubeColor);
        return numCubes != null ? numCubes : 0;
    }

    public int getNumberOfColors() {
        return cubes.size();
    }

    protected void addCubeCount(String color, int count) {
        if(count > 0)
            cubes.put(color, count);
    }

    public static BagGrab build(String grabString) {

        BagGrab grab = new BagGrab();

        if (grabString != null && !grabString.isEmpty()) {
            for (String cube : grabString.split(",")) {
                String[] cubeInfo = cube.trim().split("\\s");
                grab.addCubeCount(cubeInfo[1].trim(), Integer.parseInt(cubeInfo[0].trim()));
            }
        }

        return grab;
    }
}
