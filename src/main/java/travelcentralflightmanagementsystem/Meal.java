/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class Meal {
    private int mealID;
    private String mealName;
    private String mealDescription;
    private double mealPrice;

    public Meal(int mealID, String mealName, String mealDescription, double mealPrice) {
        this.mealID = mealID;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealPrice = mealPrice;
    }

    public int getMealID() {
        return mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public double getMealPrice() {
        return mealPrice;
    }
}
