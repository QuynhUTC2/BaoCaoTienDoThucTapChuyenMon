package com.tovonhuquynh.model;

public class exercise {
    private int exrID;
    private String exName;
    private String time;
    private String linkyoutube;
    private int day;
    private int exID;
    private int img_ex;

    public exercise(int exrID, String exName, String time, String linkyoutube, int day, int exID, int img_ex) {
        this.exrID = exrID;
        this.exName = exName;
        this.time = time;
        this.linkyoutube = linkyoutube;
        this.day = day;
        this.exID = exID;
        this.img_ex = img_ex;
    }

    public int getExrID() {
        return exrID;
    }

    public void setExrID(int exrID) {
        this.exrID = exrID;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLinkyoutube() {
        return linkyoutube;
    }

    public void setLinkyoutube(String linkyoutube) {
        this.linkyoutube = linkyoutube;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getExID() {
        return exID;
    }

    public void setExID(int exID) {
        this.exID = exID;
    }

    public int getImg_ex() {
        return img_ex;
    }

    public void setImg_ex(int img_ex) {
        this.img_ex = img_ex;
    }
}
