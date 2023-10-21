/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class Airport {
    private int airportID;
    private String airportName;
    private String airportIATACode;
    private int cityID;
    
    public Airport() {
        
    }

    public Airport(int airportID, String airportName, String airportIATACode, int cityID) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportIATACode = airportIATACode;
        this.cityID = cityID;
    }

    // Getter and Setter for airportID
    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    // Getter and Setter for airportName
    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    // Getter and Setter for airportIATACode
    public String getAirportIATACode() {
        return airportIATACode;
    }

    public void setAirportIATACode(String airportIATACode) {
        this.airportIATACode = airportIATACode;
    }

    // Getter and Setter for cityID
    public int getCityID() {
        return cityID;
    }
    

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
}
