/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class MealType {
    private int mealTypeID;
    private String mealTypeName;

    public MealType(int mealTypeID, String mealTypeName) {
        this.mealTypeID = mealTypeID;
        this.mealTypeName = mealTypeName;
    }

    public int getMealTypeID() {
        return mealTypeID;
    }

    public String getMealTypeName() {
        return mealTypeName;
    }
}
