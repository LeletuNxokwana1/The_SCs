/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class RoomType {
    private int roomTypeID;
    private String roomTypeName;
    private String roomTypeDescription;
    private int roomTypeMaxGuests;
    private float roomTypeCost;
    private int roomTypeNumBedrooms;

    // Constructor
    public RoomType(int roomTypeID, String roomTypeName, String roomTypeDescription,
                    int roomTypeMaxGuests, float roomTypeCost, int roomTypeNumBedrooms) {
        this.roomTypeID = roomTypeID;
        this.roomTypeName = roomTypeName;
        this.roomTypeDescription = roomTypeDescription;
        this.roomTypeMaxGuests = roomTypeMaxGuests;
        this.roomTypeCost = roomTypeCost;
        this.roomTypeNumBedrooms = roomTypeNumBedrooms;
    }
    
    public RoomType() {
        
    }

    // Getters
    public int getRoomTypeID() {
        return roomTypeID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public int getRoomTypeMaxGuests() {
        return roomTypeMaxGuests;
    }

    public float getRoomTypeCost() {
        return roomTypeCost;
    }

    public int getRoomTypeNumBedrooms() {
        return roomTypeNumBedrooms;
    }

    // Setters
    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public void setRoomTypeDescription(String roomTypeDescription) {
        this.roomTypeDescription = roomTypeDescription;
    }

    public void setRoomTypeMaxGuests(int roomTypeMaxGuests) {
        this.roomTypeMaxGuests = roomTypeMaxGuests;
    }

    public void setRoomTypeCost(float roomTypeCost) {
        this.roomTypeCost = roomTypeCost;
    }

    public void setRoomTypeNumBedrooms(int roomTypeNumBedrooms) {
        this.roomTypeNumBedrooms = roomTypeNumBedrooms;
    }
}