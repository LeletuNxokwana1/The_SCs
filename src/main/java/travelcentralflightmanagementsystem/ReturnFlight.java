/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
public class ReturnFlight {
    // Attributes
    private int scheduledFlightID;
    private float scheduledFlightPrice;
    private String scheduledFlightDepartureDate;
    private String scheduledFlightDepartureTime;
    private String scheduledFlightArrivalDate;
    String scheduledFlightArrivalTime;
    private String scheduledFlightStatus;
    private int departureAirportID;
    private int arrivalAirportID;
    private int aircraftID;
    private int numFlights;

    // Constructors
    public ReturnFlight() {
    }
    
    public ReturnFlight(int numFlights) {
        this.numFlights = numFlights;
    }

    public ReturnFlight(int scheduledFlightID, float scheduledFlightPrice, String scheduledFlightDepartureDate, String scheduledFlightDepartureTime, String scheduledFlightArrivalDate, String scheduledFlightArrivalTime, String scheduledFlightStatus, int departureAirportID,
                           int arrivalAirportID, int aircraftID) {
        this.scheduledFlightID = scheduledFlightID;
        this.scheduledFlightPrice = scheduledFlightPrice;
        this.scheduledFlightDepartureDate = scheduledFlightDepartureDate;
        this.scheduledFlightDepartureTime = scheduledFlightDepartureTime;
        this.scheduledFlightArrivalDate = scheduledFlightArrivalDate;
        this.scheduledFlightArrivalTime = scheduledFlightArrivalTime;
        this.scheduledFlightStatus = scheduledFlightStatus;
        this.departureAirportID = departureAirportID;
        this.arrivalAirportID = arrivalAirportID;
        this.aircraftID = aircraftID;
    }

    // Getters and Setters
    public int getNumFlights() {
        return numFlights;
    }

    public void setNumFlights(int numFlights) {
        this.numFlights = numFlights;
    }
    
    public int getScheduledFlightID() {
        return scheduledFlightID;
    }

    public void setScheduledFlightID(int scheduledFlightID) {
        this.scheduledFlightID = scheduledFlightID;
    }

    public float getScheduledFlightPrice() {
        return scheduledFlightPrice;
    }

    public void setScheduledFlightPrice(float scheduledFlightPrice) {
        this.scheduledFlightPrice = scheduledFlightPrice;
    }

    public String getScheduledFlightDepartureDate() {
        return scheduledFlightDepartureDate;
    }

    public void setScheduledFlightDepartureDate(String scheduledFlightDepartureDate) {
        this.scheduledFlightDepartureDate = scheduledFlightDepartureDate;
    }
    
    public String getScheduledFlightDepartureTime() {
        return scheduledFlightDepartureTime;
    }

    public void setScheduledFlightDepartureTime(String scheduledFlightDepartureTime) {
        this.scheduledFlightDepartureTime = scheduledFlightDepartureTime;
    }

    public String getScheduledFlightArrivalDate() {
        return scheduledFlightArrivalDate;
    }
    

    public void setScheduledFlightArrivalDate(String scheduledFlightArrivalDate) {
        this.scheduledFlightArrivalDate = scheduledFlightArrivalDate;
    }
    
    public String getScheduledFlightArrivalTime() {
        return scheduledFlightArrivalTime;
    }

    public void setScheduledFlightArrivalTime(String scheduledFlightArrivalTime) {
        this.scheduledFlightArrivalTime = scheduledFlightArrivalTime;
    }

    public String getScheduledFlightStatus() {
        return scheduledFlightStatus;
    }

    public void setScheduledFlightStatus(String scheduledFlightStatus) {
        this.scheduledFlightStatus = scheduledFlightStatus;
    }

    public int getDepartureAirportID() {
        return departureAirportID;
    }

    public void setDepartureAirportID(int departureAirportID) {
        this.departureAirportID = departureAirportID;
    }

    public int getArrivalAirportID() {
        return arrivalAirportID;
    }

    public void setArrivalAirportID(int arrivalAirportID) {
        this.arrivalAirportID = arrivalAirportID;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }
}
