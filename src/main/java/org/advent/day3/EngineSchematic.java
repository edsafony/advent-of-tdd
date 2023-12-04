package org.advent.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EngineSchematic {

    private List<String> rows;
    private List<Character[]> symbols;
    private List<Integer[]> numbers;

    public EngineSchematic() {
        rows = new ArrayList<>();
        symbols = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    /**
     * Create an engine Schematic from the given schemaFile
     * 
     * @param schemaFile engine schema located somewhere in the classpath
     * @throws IOException
     */
    public EngineSchematic(String schemaFile) throws IOException {
        this();

        InputStream inputStream = this.getClass().getResourceAsStream(schemaFile);
        if(inputStream==null)
            throw new IllegalStateException("Unable to fine file "+schemaFile);
        
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        
        String line="";
        while((line=reader.readLine())!=null) {
            this.addSchemaRow(line);
        }
    }

    public int size() {
        return rows.size();
    }

    private void initRow(int row, String rowString) {
        rows.add(row, rowString);
        if (symbols.isEmpty() || symbols.size() - 1 <= row)
            symbols.add(row, new Character[rowString.length()]);
        if (numbers.isEmpty() || numbers.size() - 1 <= row)
            numbers.add(row, new Integer[rowString.length()]);
    }

    public void addSchemaRow(String schemaRow) {
        addSchemaRow(this.size(), schemaRow);
    }

    public void addSchemaRow(int row, String schemaRow) {
        initRow(row, schemaRow);

        // parse symbols
        for (int i = 0; i < schemaRow.length(); i++) {
            if (isSymbol(schemaRow.charAt(i)))
                this.symbols.get(row)[i] = schemaRow.charAt(i);
        }

        // parse numbers
        for (int i = 0; i < schemaRow.length(); i++) {
            if (Character.isDigit(schemaRow.charAt(i))) {
                int column = i;
                StringBuilder num = new StringBuilder().append(schemaRow.charAt(i));
                i++;
                while (i < schemaRow.length() && Character.isDigit(schemaRow.charAt(i))) {
                    num.append(schemaRow.charAt(i));
                    i++;
                }
                this.numbers.get(row)[column] = Integer.parseInt(num.toString());
            }
        }
    }

    public boolean isValidSymbol(int x, int y) {
        return x >= 0 && x < this.size() && y >= 0 && y < this.rows.get(x).length() &&
                this.symbols.get(x) != null && // there are symbols at this row
                isSymbol(this.rows.get(x).charAt(y)); // the character in that colum is a symbol
    }

    /**
     * Get the number as x, y coordinate or NULL
     * 
     * @return the number starting at x, y coordinate else NULL
     */
    public Integer getNumber(int x, int y) {
        if (!this.numbers.isEmpty() &&
            !(x<0 || x>this.numbers.size() || y<0 || y>this.numbers.get(x).length)) {
                return this.numbers.get(x)[y];
        }

        return null;
    }

    /**
     * Determine if the number at x, y is a valid part number (i.e., next to a
     * symbol)
     * 
     * @param x
     * @param y
     * @return TRUE if x, y is valid, else FALSE
     */
    public boolean isPartNumber(int x, int y) {
        Integer part = getNumber(x, y);

        if (part == null)
            return false;

        boolean flag = false;
        for (int i = 0; !flag && i < part.toString().length(); i++)
            flag = nearSymbol(x, y + i);

        return flag;
    }

    public int getSumAllParts() {
        int sum=0;
        for(int i=0; i<this.numbers.size(); i++) {
            Integer[] numberRow = this.numbers.get(i);
            for(int j=0; j<numberRow.length; j++)
                if(this.isPartNumber(i, j))
                    sum += numberRow[j];
        }
        return sum;
    }

    public int getSumGearRatios() {
        int sum=0;
        for(int i=0; i<this.symbols.size(); i++) {
            Character[] symbolRow = this.symbols.get(i);
            for(int j=0; j<symbolRow.length; j++) {
                sum += getGearRatio(i, j, symbolRow[j]);
            }
        }
        return sum;
    }

    private int getGearRatio(int x, int y, Character symbol) {
        if(isValidSymbol(x, y) && symbol == '*') {
            ArrayList<Integer> closeParts = new ArrayList<>();

            Integer num = getNumber(x-1, y-1);
            if(num!=null) closeParts.add(num);
            num = getNumber(x-1, y);
            if(num!=null) closeParts.add(num);
            num = getNumber(x-1, y+1);
            if(num!=null) closeParts.add(num);
            num = getNumber(x, y-1);
            if(num!=null) closeParts.add(num);
            num = getNumber(x-1, y+1);
            if(num!=null) closeParts.add(num);
            num = getNumber(x+1, y-1);
            if(num!=null) closeParts.add(num);
            num = getNumber(x+1, y);
            if(num!=null) closeParts.add(num);
            num = getNumber(x+1, y+1);
            if(num!=null) closeParts.add(num);

            if(closeParts.size()==2)
                return closeParts.get(0)*closeParts.get(1);
        }

        return 0;
    }
    private boolean nearSymbol(int x, int y) {
        return isValidSymbol(x - 1, y - 1) ||
                isValidSymbol(x - 1, y) ||
                isValidSymbol(x - 1, y + 1) ||
                isValidSymbol(x, y - 1) ||
                isValidSymbol(x, y + 1) ||
                isValidSymbol(x + 1, y - 1) ||
                isValidSymbol(x + 1, y) ||
                isValidSymbol(x + 1, y + 1);
    }

    private boolean isSymbol(Character c) {
        return !Character.isDigit(c) && c != '.';
    }
}
