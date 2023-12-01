package org.advent.day1;

public class Calibration {
    private String calibrationString;

    public Calibration() {
        this.calibrationString = "";
    }

    public Calibration(String calibrationValue) {
        this.calibrationString=calibrationValue;
    }

    public void setCalibrationValue(String calibrationValue) {
        this.calibrationString=calibrationValue;
    }

    public int getFirstDigit() {
        for(char c : this.calibrationString.toCharArray())
            if(Character.isDigit(c))
                return Integer.parseInt(String.valueOf(c));

        return 0;
    }

    public int getLastDigit() {
        for(int i=this.calibrationString.length()-1; i>=0; i--)
            if(Character.isDigit(this.calibrationString.charAt(i)))
                return Integer.parseInt(String.valueOf(this.calibrationString.charAt(i)));

        return 0;
    }

    public int getCalibrationValue() {
        if(this.calibrationString == null || this.calibrationString.length()==0)
            return 0;
        else return Integer.parseInt(getFirstDigit()+""+getLastDigit());
    }
}
