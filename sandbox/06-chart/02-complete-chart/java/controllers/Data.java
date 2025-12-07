package controllers;

public class Data {
    public String month;
    public int num;

    public int xVal;
    public int yVal;
    public int range;

    public Data(String month, int num) {
        this.month = month;
        this.num = num;
    }

    public Data(int xVal, int yVal, int range) {
        this.xVal = xVal;
        yVal = yVal;
        this.range = range;
    }
}
