/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class Aircraft {
    // Attributes
    private int aircraftID;
    private String aircraftName;
    private int aircraftMaxCapacity;
    private String aircraftStatus;
    private int aircraftEcnmyCapacity;
    private int aircraftBsnsCapacity;
    private int aircraftFstCapacity;

    // Constructors
    public Aircraft() {
    }

    public Aircraft(int aircraftID, String aircraftName, int aircraftMaxCapacity, String aircraftStatus, int aircraftEcnmyCapacity, int aircraftBsnsCapacity, int aircraftFstCapacity) {
        this.aircraftID = aircraftID;
        this.aircraftName = aircraftName;
        this.aircraftMaxCapacity = aircraftMaxCapacity;
        this.aircraftStatus = aircraftStatus;
        this.aircraftEcnmyCapacity = aircraftEcnmyCapacity;
        this.aircraftBsnsCapacity = aircraftBsnsCapacity;
        this.aircraftFstCapacity = aircraftFstCapacity;
    }

    // Getters and Setters
    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public int getAircraftMaxCapacity() {
        return aircraftMaxCapacity;
    }

    public void setAircraftMaxCapacity(int aircraftMaxCapacity) {
        this.aircraftMaxCapacity = aircraftMaxCapacity;
    }

    public String getAircraftStatus() {
        return aircraftStatus;
    }

    public void setAircraftStatus(String aircraftStatus) {
        this.aircraftStatus = aircraftStatus;
    }
    
    public int getAircraftEcnmyCapacity() {
        return aircraftEcnmyCapacity;
    }

    public void setAircraftEcnmyCapacity(int aircraftEcnmyCapacity) {
        this.aircraftEcnmyCapacity = aircraftEcnmyCapacity;
    }
    
    public int getAircraftBsnsCapacity() {
        return aircraftBsnsCapacity;
    }

    public void setAircraftBsnsCapacity(int aircraftBsnsCapacity) {
        this.aircraftBsnsCapacity = aircraftBsnsCapacity;
    }
    
    public int getAircraftFstCapacity() {
        return aircraftFstCapacity;
    }

    public void setAircraftFstCapacity(int aircraftFstCapacity) {
        this.aircraftFstCapacity = aircraftFstCapacity;
    }
}
