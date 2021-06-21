package com.tovonhuquynh.model;

public class MonAn {
    private int Idmonan;
    private String Tenmonan;
    private String mealTime;

    public MonAn(int idmonan, String tenmonan, String mealTime) {
        Idmonan = idmonan;
        Tenmonan = tenmonan;
        this.mealTime = mealTime;
    }

    public int getIdmonan() {
        return Idmonan;
    }

    public void setIdmonan(int idmonan) {
        Idmonan = idmonan;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
}
