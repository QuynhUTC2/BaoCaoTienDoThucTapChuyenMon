package com.tovonhuquynh.model;

import java.io.Serializable;

public class InfoUser implements Serializable {
    private int inForID;
    private String Sex;
    private double Height;
    private double Weight;
    private double Chest;
    private double Waist;
    private double Hips;
    private String userName;
    private int solutionID;

    public InfoUser(int inForID, String sex, double height, double weight, double chest, double waist, double hips, String userName,int solutionID) {
        this.inForID = inForID;
        Sex = sex;
        Height = height;
        Weight = weight;
        Chest = chest;
        Waist = waist;
        Hips = hips;
        this.userName = userName;
        this.solutionID =solutionID;
    }

    public int getInForID() {
        return inForID;
    }

    public void setInForID(int inForID) {
        this.inForID = inForID;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getChest() {
        return Chest;
    }

    public void setChest(double chest) {
        Chest = chest;
    }

    public double getWaist() {
        return Waist;
    }

    public void setWaist(double waist) {
        Waist = waist;
    }

    public double getHips() {
        return Hips;
    }

    public void setHips(double hips) {
        Hips = hips;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSolutionID() {
        return solutionID;
    }

    public void setSolutionID(int solutionID) {
        this.solutionID = solutionID;
    }

    @Override
    public String toString() {
        return inForID + " " + Sex + " " + Height + " " + Weight + " " + Chest + " " + Waist + " " + Hips + " " + userName ;
    }
}
