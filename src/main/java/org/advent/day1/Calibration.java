package org.advent.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibration {
    private String calibrationString;
    static Pattern numberPattern = Pattern.compile(
        "\\d|zero|one|two|three|four|five|six|seven|eight|nine");
    static String[] numericWords = new String[]{
        "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    Map<String, Integer> numberMap;

    public Calibration() {
        this.calibrationString = "";
        numberMap = new HashMap<String, Integer>();
        for(int i=0; i<numericWords.length; i++)
            numberMap.put(numericWords[i], i);
    }

    public Calibration(String calibrationValue) {
        this();
        this.setCalibrationValue(calibrationValue);
    }

    public void setCalibrationValue(String calibrationValue) {
        this.calibrationString=calibrationValue;
    }

    public int getFirstDigit() {
        Matcher matcher = numberPattern.matcher(this.calibrationString);

        if(matcher.find()) {
            String match = matcher.group();
            return convert(match);
        } else return 0;
    }

    public int getLastDigit() {
        Matcher matcher = numberPattern.matcher(this.calibrationString);

        int matchIndex=0;
        String lastMatch="";
        while(matcher.find(matchIndex) && !matcher.hitEnd()) {
            lastMatch=matcher.group();
            matchIndex=matcher.end();
        }

        if(matchIndex>0)
            return convert(lastMatch);
        else return 0;
    }

    public int getCalibrationValue() {
        if(this.calibrationString == null || this.calibrationString.length()==0)
            return 0;
        else return Integer.parseInt(getFirstDigit()+""+getLastDigit());
    }

    private int convert(String number) {
        if(number != null && number.length()==1 && Character.isDigit(number.charAt(0)) )
            return Integer.parseInt(number);
        else return numberMap.get(number);
    }
}
