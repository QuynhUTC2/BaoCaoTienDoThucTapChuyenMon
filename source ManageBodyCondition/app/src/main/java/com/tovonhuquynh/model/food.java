package com.tovonhuquynh.model;

public class food {

    private int iddetail;
    private String foodname;
    private int dietID;
    private int day;
    private String mealtime;
    private int imgfood;

    public food(int iddetail, String foodname, int dietID, int day, String mealtime, int imgfood) {
        this.iddetail = iddetail;
        this.foodname = foodname;
        this.dietID = dietID;
        this.day = day;
        this.mealtime = mealtime;
        this.imgfood = imgfood;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMealtime() {
        return mealtime;
    }

    public void setMealtime(String mealtime) {
        this.mealtime = mealtime;
    }

    public int getDietID() {
        return dietID;
    }

    public void setDietID(int dietID) {
        this.dietID = dietID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getIddetail() {
        return iddetail;
    }

    public void setIddetail(int iddetail) {
        this.iddetail = iddetail;
    }

    public int getImgfood() {
        return imgfood;
    }

    public void setImgfood(int imgfood) {
        this.imgfood = imgfood;
    }
}
