/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author okhum
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramManager {

    ////////////////////////////////////////// Get Airports from DB //////////////////////////////////////////
    public List<Airport> retrieveAirports() {
        List<Airport> airports = new ArrayList<>();
        String sql = "SELECT airportID, airportName, airportIATACode, cityID FROM airport";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int airportID = resultSet.getInt("airportID");
                    String airportName = resultSet.getString("airportName");
                    String airportIATACode = resultSet.getString("airportIATACode");
                    int cityID = resultSet.getInt("cityID");

                    Airport airport = new Airport(airportID, airportName, airportIATACode, cityID);
                    airports.add(airport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return airports;
    }

    ////////////////////////////////////////// Get the Airport CityID by AirportName from the DB airport table //////////////////////////////////////////
    public int retrieveCityID(String airportName) {
        int cityID = -1; // Default value if the airport name is not found

        String sql = "SELECT cityID FROM airport WHERE airportName = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, airportName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cityID = resultSet.getInt("cityID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityID;
    }

    ////////////////////////////////////////// Get the scheduled flights by date, departure airport and arrival airport from the DB scheduledFlight table //////////////////////////////////////////
    public List<ScheduledFlight> retrieveFlights(String departureAirport, String arrivalAirport, Date date) {
        
        List<ScheduledFlight> flights = new ArrayList<>();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // Convert java.util.date to java.sql.date

        String sql = "SELECT sf.* FROM scheduledFlight sf INNER JOIN airport depAirport ON sf.departureAirportID = depAirport.airportID " +
                 "INNER JOIN airport arrAirport ON sf.arrivalAirportID = arrAirport.airportID " +
                 "WHERE depAirport.airportName = ? AND arrAirport.airportName = ? AND DATE(sf.scheduledFlightDepartureDate) = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, departureAirport);
            preparedStatement.setString(2, arrivalAirport);
            preparedStatement.setDate(3, sqlDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int scheduledFlightID = resultSet.getInt("scheduledFlightID");
                    float scheduledFlightPrice = resultSet.getFloat("scheduledFlightPrice");
                    
                    // Get departure time
                    java.sql.Timestamp timestamp = resultSet.getTimestamp("scheduledFlightDepartureDate"); // Retrieve the DATETIME value as a java.sql.Timestamp
                    Date retrievedDate = new Date(timestamp.getTime()); // Convert the java.sql.Timestamp to a java.util.Date
                    // Format date and time separately
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String scheduledFlightDepartureDate = dateFormat.format(retrievedDate);
                    String scheduledFlightDepartureTime = timeFormat.format(retrievedDate);
                    
                    // Get arrival time
                    java.sql.Timestamp timestamp1 = resultSet.getTimestamp("scheduledFlightArrivalDate"); // Retrieve the DATETIME value as a java.sql.Timestamp
                    Date retrievedDate1 = new Date(timestamp1.getTime()); // Convert the java.sql.Timestamp to a java.util.Date
                    // Format date and time separately
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH:mm");
                    String scheduledFlightArrivalDate = dateFormat1.format(retrievedDate1);
                    String scheduledFlightArrivalTime = timeFormat1.format(retrievedDate1);
                    
                    String scheduledFlightStatus = resultSet.getString("scheduledFlightStatus");
                    int departureAirportID = resultSet.getInt("departureAirportID");
                    int arrivalAirportID = resultSet.getInt("arrivalAirportID");
                    int aircraftID = resultSet.getInt("aircraftID");

                    ScheduledFlight flight = new ScheduledFlight(scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate, scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime, scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID);
                    flights.add(flight);
                }
                int numFlights = flights.size();
                ScheduledFlight flight = new ScheduledFlight(numFlights);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
    
    ////////////////////////////////////////// Get the scheduled flights by date, departure airport and arrival airport from the DB scheduledFlight table //////////////////////////////////////////
    public List<ScheduledFlight> retrieveReturnFlights(String departureAirport, String arrivalAirport, Date date) {
        
        List<ScheduledFlight> flights = new ArrayList<>();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // Convert java.util.date to java.sql.date

        String sql = "SELECT sf.* FROM scheduledFlight sf INNER JOIN airport depAirport ON sf.departureAirportID = depAirport.airportID " +
                 "INNER JOIN airport arrAirport ON sf.arrivalAirportID = arrAirport.airportID " +
                 "WHERE depAirport.airportName = ? AND arrAirport.airportName = ? AND DATE(sf.scheduledFlightDepartureDate) = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, departureAirport);
            preparedStatement.setString(2, arrivalAirport);
            preparedStatement.setDate(3, sqlDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int scheduledFlightID = resultSet.getInt("scheduledFlightID");
                    float scheduledFlightPrice = resultSet.getFloat("scheduledFlightPrice");
                    
                    // Get departure time
                    java.sql.Timestamp timestamp = resultSet.getTimestamp("scheduledFlightDepartureDate"); // Retrieve the DATETIME value as a java.sql.Timestamp
                    Date retrievedDate = new Date(timestamp.getTime()); // Convert the java.sql.Timestamp to a java.util.Date
                    // Format date and time separately
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String scheduledFlightDepartureDate = dateFormat.format(retrievedDate);
                    String scheduledFlightDepartureTime = timeFormat.format(retrievedDate);
                    
                    // Get arrival time
                    java.sql.Timestamp timestamp1 = resultSet.getTimestamp("scheduledFlightArrivalDate"); // Retrieve the DATETIME value as a java.sql.Timestamp
                    Date retrievedDate1 = new Date(timestamp1.getTime()); // Convert the java.sql.Timestamp to a java.util.Date
                    // Format date and time separately
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH:mm");
                    String scheduledFlightArrivalDate = dateFormat1.format(retrievedDate1);
                    String scheduledFlightArrivalTime = timeFormat1.format(retrievedDate1);
                    
                    String scheduledFlightStatus = resultSet.getString("scheduledFlightStatus");
                    int departureAirportID = resultSet.getInt("departureAirportID");
                    int arrivalAirportID = resultSet.getInt("arrivalAirportID");
                    int aircraftID = resultSet.getInt("aircraftID");

                    ScheduledFlight flight = new ScheduledFlight(scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate, scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime, scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID);
                    flights.add(flight);
                }
                int numFlights = flights.size();
                ScheduledFlight flight = new ScheduledFlight(numFlights);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
    
    ////////////////////////////////////////// Get aircraft information by aircraftID from the DB aircraft table //////////////////////////////////////////
    public Aircraft retrieveAircraftInfo(int aircraftID) {

        Aircraft aircraft = null;
        String sql = "SELECT * FROM aircraft WHERE aircraftID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, aircraftID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int retrievedAircraftID = resultSet.getInt("aircraftID");
                    String aircraftName = resultSet.getString("aircraftName");
                    int aircraftMaxCapacity = resultSet.getInt("aircraftMaxCapacity");
                    String aircraftStatus = resultSet.getString("aircraftStatus");
                    int aircraftEcnmyCapacity = resultSet.getInt("aircraftEcnmyCapacity");
                    int aircraftBsnsCapacity = resultSet.getInt("aircraftBsnsCapacity");
                    int aircraftFstCapacity = resultSet.getInt("aircraftFstCapacity");
                    
                    aircraft = new Aircraft(retrievedAircraftID, aircraftName, aircraftMaxCapacity, aircraftStatus, aircraftEcnmyCapacity, aircraftBsnsCapacity, aircraftFstCapacity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aircraft;
    }
    
    ////////////////////////////////////////// Count total number of passengers for bookings by scheduledFlightID and class //////////////////////////////////////////
    public int countPassengersByScheduledFlightAndClass(int scheduledFlightID, int classID) {
        int totalPassengers = 0;
        String sql = "SELECT SUM(flightBookingNumPassengers) AS totalPassengers " +
                     "FROM flightBooking " +
                     "WHERE scheduledFlightID = ? AND classID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scheduledFlightID);
            preparedStatement.setInt(2, classID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalPassengers = resultSet.getInt("totalPassengers");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPassengers;
    }
    
    ////////////////////////////////////////// Get classID by class name //////////////////////////////////////////
    public int retrieveClassID(String className) {
        int classID = -1; // Default to -1 if class name is not found
        String sql = "SELECT classID FROM class WHERE className = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, className);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    classID = resultSet.getInt("classID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classID;
    }
    
    ////////////////////////////////////////// Get class price by class ID //////////////////////////////////////////
    public float retrieveClassPrice(int classID) {
        float classPrice = 0; // Default to 0.0 if class ID is not found
        String sql = "SELECT classPrice FROM class WHERE classID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, classID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    classPrice = resultSet.getFloat("classPrice");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classPrice;
    }
    
    ////////////////////////////////////////// Get IATA code by airport name //////////////////////////////////////////
    public String retrieveIATA(String airportName) {
        String iataCode = ""; // Default to an empty string if airport name is not found
        String sql = "SELECT airportIATACode FROM airport WHERE airportName = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, airportName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    iataCode = resultSet.getString("airportIATACode");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return iataCode;
    }
}
