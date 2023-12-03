package org.advent.day3;

import java.util.List;

public class EngineSchematic {

    public EngineSchematic() {}

    /**
     * Create an engine Schematic from the given schemaFile
     * @param schemaFile engine schema located somewhere in the classpath
     */
    public EngineSchematic(String schemaFile) {
    }

    public int size() {
        return 0;// not implemented
    }

    public void addSchemaRow(int row, String schemaRow) {

    }

    public boolean isValidSymbol(int x, int y){
        return false;//not implemented
    }

    /**
     * Find all numbers in the scheamticLine
     * 
     * @param schematicLine a string representing a line from the engine schematic
     *                      input
     * @return a list of the numbers extracted from that line
     */
    public List<Integer> findNumbers(String schematicLine) {
        return null;// not implemented
    }

    /**
     * Get the number as x, y coordinate or NULL
     * 
     * @return the number starting at x, y coordinate else NULL
     */
    public Integer getNumber(int x, int y) {
        return null;// not implemented
    }

    /**
     * Determine if the number at x, y is a valid part number (i.e., next to a symbol)
     * 
     * @param x
     * @param y
     * @return TRUE if x, y is valid, else FALSE
     */
    public boolean isPartNumber(int x, int y) {
        return false;//not implemented
    }
}
