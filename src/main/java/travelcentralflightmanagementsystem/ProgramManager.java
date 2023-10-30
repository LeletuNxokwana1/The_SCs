/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Statement;
import travelcentralflightmanagementsystem.User.UserStatus;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    public List<DepartureFlight> retrieveFlights(String departureAirport, String arrivalAirport, Date date) {

        List<DepartureFlight> flights = new ArrayList<>();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // Convert java.util.date to java.sql.date

        // Updated SQL query with correct parameter positions
        String sql = "SELECT * FROM scheduledFlight "
                + "WHERE departureAirportID = (SELECT airportID FROM airport WHERE airportName = ?) "
                + "AND arrivalAirportID = (SELECT airportID FROM airport WHERE airportName = ?) "
                + "AND DATE(scheduledFlightDepartureDate) = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set parameters in the correct order
            preparedStatement.setString(1, departureAirport);
            preparedStatement.setString(2, arrivalAirport);
            preparedStatement.setString(3, sqlDate.toString());  // Convert to string for comparison

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No flights found for the specified criteria.");
                } else {
                    while (resultSet.next()) {
                        int scheduledFlightID = resultSet.getInt("scheduledFlightID");
                        float scheduledFlightPrice = resultSet.getFloat("scheduledFlightPrice");

                        // Get departure time
                        java.sql.Timestamp timestamp = resultSet.getTimestamp("scheduledFlightDepartureDate");
                        Date retrievedDate = new Date(timestamp.getTime());
                        // Format date and time separately
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        String scheduledFlightDepartureDate = dateFormat.format(retrievedDate);
                        String scheduledFlightDepartureTime = timeFormat.format(retrievedDate);

                        // Get arrival time
                        java.sql.Timestamp timestamp1 = resultSet.getTimestamp("scheduledFlightArrivalDate");
                        Date retrievedDate1 = new Date(timestamp1.getTime());
                        // Format date and time separately
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH:mm");
                        String scheduledFlightArrivalDate = dateFormat1.format(retrievedDate1);
                        String scheduledFlightArrivalTime = timeFormat1.format(retrievedDate1);

                        String scheduledFlightStatus = resultSet.getString("scheduledFlightStatus");
                        int departureAirportID = resultSet.getInt("departureAirportID");
                        int arrivalAirportID = resultSet.getInt("arrivalAirportID");
                        int aircraftID = resultSet.getInt("aircraftID");

                        DepartureFlight flight = new DepartureFlight(scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate, scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime, scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID);
                        flights.add(flight);

                        System.out.println("Flight found:");
                        System.out.println("scheduledFlightID: " + scheduledFlightID);
                        System.out.println("Scheduled Departure Date: " + scheduledFlightDepartureDate);
                        System.out.println("Scheduled Departure Time: " + scheduledFlightDepartureTime);
                        System.out.println("Scheduled Arrival Date: " + scheduledFlightArrivalDate);
                        System.out.println("Scheduled Arrival Time: " + scheduledFlightArrivalTime);
                        System.out.println("Flight Status: " + scheduledFlightStatus);
                        System.out.println("Departure Airport ID: " + departureAirportID);
                        System.out.println("Arrival Airport ID: " + arrivalAirportID);
                        System.out.println("Aircraft ID: " + aircraftID);
                    }
                    
                    int numFlights = flights.size();
                    DepartureFlight flight = new DepartureFlight(numFlights);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    ////////////////////////////////////////// Get the scheduled flights by date, departure airport and arrival airport from the DB scheduledFlight table //////////////////////////////////////////
    public List<ReturnFlight> retrieveReturnFlights(String departureAirport, String arrivalAirport, Date date) {

        List<ReturnFlight> flights = new ArrayList<>();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // Convert java.util.date to java.sql.date

        String sql = "SELECT sf.* FROM scheduledFlight sf INNER JOIN airport depAirport ON sf.departureAirportID = depAirport.airportID "
                + "INNER JOIN airport arrAirport ON sf.arrivalAirportID = arrAirport.airportID "
                + "WHERE depAirport.airportName = ? AND arrAirport.airportName = ? AND DATE(sf.scheduledFlightDepartureDate) = ?";

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

                    ReturnFlight flight = new ReturnFlight(scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate, scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime, scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID);
                    flights.add(flight);
                }
                int numFlights = flights.size();
                ReturnFlight flight = new ReturnFlight(numFlights);
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
        String sql = "SELECT SUM(flightBookingNumPassengers) AS totalPassengers "
                + "FROM flightBooking "
                + "WHERE depScheduledFlightID = ? AND classID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

    ////////////////////////////////////////// Get Hotel Room Types //////////////////////////////////////////
    public List<RoomType> retrieveRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();

        String sql = "SELECT * FROM roomtype";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    RoomType roomType = new RoomType();
                    roomType.setRoomTypeID(resultSet.getInt("roomTypeID"));
                    roomType.setRoomTypeName(resultSet.getString("roomTypeName"));
                    roomType.setRoomTypeDescription(resultSet.getString("roomTypeDescription"));
                    roomType.setRoomTypeMaxGuests(resultSet.getInt("roomTypeMaxGuests"));
                    roomType.setRoomTypeCost(resultSet.getFloat("roomTypeCost"));
                    roomType.setRoomTypeNumBedrooms(resultSet.getInt("roomTypeNumBedrooms"));

                    roomTypes.add(roomType);
                }
            }
        }

        return roomTypes;
    }

    ////////////////////////////////////////// Get the number of users //////////////////////////////////////////
    public int retrieveNumberOfUsers() {
        int numberOfUsers = 0;
        String sql = "SELECT COUNT(*) FROM user";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                numberOfUsers = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfUsers;
    }

    ////////////////////////////////////////// Get the number of hotel bookings //////////////////////////////////////////
    public int retrieveNumberOfHotelBookings() {
        int numberOfHotelBookings = 0;
        String sql = "SELECT COUNT(*) FROM hotelBooking";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                numberOfHotelBookings = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfHotelBookings;
    }

    ////////////////////////////////////////// Get the number of flight bookings //////////////////////////////////////////
    public int retrieveNumberOfFlightBookings() {
        int numberOfFlightBookings = 0;
        String sql = "SELECT COUNT(*) FROM flightBooking";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                numberOfFlightBookings = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfFlightBookings;
    }

    ////////////////////////////////////////// Get the number of car bookings //////////////////////////////////////////
    public int retrieveNumberOfCarBookings() {
        int numberOfCarBookings = 0;
        String sql = "SELECT COUNT(*) FROM carBooking";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                numberOfCarBookings = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfCarBookings;
    }

    ////////////////////////////////////////// Get hotel information //////////////////////////////////////////
    public List<Hotel> retrieveHotelInformation() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT hotelID, hotelName, hotelNumRooms, cityID FROM hotel";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int hotelID = resultSet.getInt("hotelID");
                String hotelName = resultSet.getString("hotelName");
                int numRooms = resultSet.getInt("hotelNumRooms");

                // Retrieve city information
                int cityID = resultSet.getInt("cityID");
                City city = retrieveCity(cityID);

                Hotel hotel = new Hotel(hotelID, hotelName, numRooms, city);
                hotels.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    private City retrieveCity(int cityID) {
        String sql = "SELECT cityName FROM city WHERE cityID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cityID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String cityName = resultSet.getString("cityName");
                    return new City(cityID, cityName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Handle appropriately if city retrieval fails
    }

    ////////////////////////////////////////// Update hotel information (name and number of rooms) //////////////////////////////////////////
    public void updateHotelInformation(int hotelID, String hotelName, int numRooms) {
        String sql = "UPDATE hotel SET hotelName = ?, hotelNumRooms = ? WHERE hotelID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, hotelName);
            preparedStatement.setInt(2, numRooms);
            preparedStatement.setInt(3, hotelID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Delete hotels based on the selected hotelIDs //////////////////////////////////////////
    public void deleteSelectedHotels(List<Integer> hotelIDs) {
        String sql = "DELETE FROM hotel WHERE hotelID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (int hotelID : hotelIDs) {
                preparedStatement.setInt(1, hotelID);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Add a new hotel ////////////////////////////////////////// 
    public int addHotel(String hotelName, int numRooms, int cityID) {
        String sql = "INSERT INTO hotel (hotelName, hotelNumRooms, cityID) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, hotelName);
            preparedStatement.setInt(2, numRooms);
            preparedStatement.setInt(3, cityID);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated hotelID
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Return -1 if the hotel addition fails
    }

    ////////////////////////////////////////// Get all cities from the database //////////////////////////////////////////
    public List<City> retrieveCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT cityID, cityName FROM city";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int cityID = resultSet.getInt("cityID");
                String cityName = resultSet.getString("cityName");

                City city = new City(cityID, cityName);
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    ////////////////////////////////////////// Retrieve user information //////////////////////////////////////////
    public List<User> retrieveUsersInformation() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setFirstName(resultSet.getString("userFirstName"));
                user.setLastName(resultSet.getString("userLastName"));
                user.setEmailAddress(resultSet.getString("userEmailAddress"));
                user.setPhoneNumber(resultSet.getString("userPhoneNumber"));
                user.setPassword(resultSet.getString("userPassword"));
                user.setUserStatus(User.getUserStatusFromString(resultSet.getString("userStatus")));
                user.setRetrievalQuestion(resultSet.getString("userRetrievalQuestion"));
                user.setRetrievalAnswer(resultSet.getString("userRetrievalAnswer"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    ////////////////////////////////////////// Update user status //////////////////////////////////////////
    public void updateUserStatus(int userID, User.UserStatus userStatus) {
        System.out.println("Updating status for User ID: " + userID);
        String sql = "UPDATE user SET userStatus = ? WHERE userID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userStatus.name());
            preparedStatement.setInt(2, userID);

            // Print the SQL query for debugging
            System.out.println("SQL Query: " + preparedStatement.toString());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "User status updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Count user bookings //////////////////////////////////////////
    public int countUserBookings(int userID) {
        String sql = "SELECT COUNT(*) FROM flightBooking WHERE userID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    ////////////////////////////////////////// Retrieve flight information //////////////////////////////////////////
    public List<DepartureFlight> retrieveFlights() {

        List<DepartureFlight> flights = new ArrayList<>();

        String sql = "SELECT sf.* FROM scheduledFlight sf INNER JOIN airport depAirport ON sf.departureAirportID = depAirport.airportID "
                + "INNER JOIN airport arrAirport ON sf.arrivalAirportID = arrAirport.airportID ";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

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

                    DepartureFlight flight = new DepartureFlight(scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate, scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime, scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID);
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    ////////////////////////////////////////// Update flight information //////////////////////////////////////////
    public void updateFlightDetails(int flightID, String newDepartureAirport, String newArrivalAirport,
            String newFlightStatus, String newAircraft, Date newDepartureDate,
            Date newArrivalDate, float newFlightCost) {
        String sql = "UPDATE scheduledFlight SET departureAirportID=?, arrivalAirportID=?, "
                + "scheduledFlightStatus=?, aircraftID=?, scheduledFlightDepartureDate=?, "
                + "scheduledFlightArrivalDate=?, scheduledFlightPrice=? WHERE scheduledFlightID=?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, retrieveAirportID(newDepartureAirport));
            preparedStatement.setInt(2, retrieveAirportID(newArrivalAirport));
            preparedStatement.setString(3, newFlightStatus);
            preparedStatement.setInt(4, retrieveAircraftID(newAircraft));
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(newDepartureDate.getTime()));
            preparedStatement.setTimestamp(6, new java.sql.Timestamp(newArrivalDate.getTime()));
            preparedStatement.setFloat(7, newFlightCost);
            preparedStatement.setInt(8, flightID);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Flight details updated successfully.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No rows updated. Flight not found or no changes.",
                        "No Changes", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Retrieve airport names //////////////////////////////////////////
    public List<String> getAirportNames() {
        List<String> airportNames = new ArrayList<>();

        String sql = "SELECT airportName FROM airport";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String airportName = resultSet.getString("airportName");
                airportNames.add(airportName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return airportNames;
    }

    ////////////////////////////////////////// Retrieve available flight statuses //////////////////////////////////////////
    public List<String> getFlightStatusOptions() {
        // Assuming flight status options are static, you can return them directly
        return List.of("Scheduled", "Boarding", "Delayed", "Departing", "Taking Off", "Departed",
                "Landing", "Taxiing", "Arrived", "Canceled");
    }

    ////////////////////////////////////////// Retrieve aircraft names //////////////////////////////////////////
    public List<String> getAircraftNames() {
        List<String> aircraftNames = new ArrayList<>();

        String sql = "SELECT aircraftName FROM aircraft";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String aircraftName = resultSet.getString("aircraftName");
                aircraftNames.add(aircraftName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aircraftNames;
    }

    ////////////////////////////////////////// Add a new airport //////////////////////////////////////////
    public void addAirport(String airportName, String iataCode, String cityName) {
        int cityID = getCityIDByName(cityName);

        String insertAirportQuery = "INSERT INTO airport (airportName, airportIATACode, cityID) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement airportStatement = connection.prepareStatement(insertAirportQuery)) {

            airportStatement.setString(1, airportName);
            airportStatement.setString(2, iataCode);
            airportStatement.setInt(3, cityID);

            airportStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Retrieve city ID using city name //////////////////////////////////////////
    public int getCityIDByName(String cityName) {
        String getCityIDQuery = "SELECT cityID FROM city WHERE cityName = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(getCityIDQuery)) {

            statement.setString(1, cityName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("cityID");
            } else {
                System.out.println("City not found");
                return -1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    ////////////////////////////////////////// Retrieve city name using city ID //////////////////////////////////////////
    public String getCityNameByID(int cityID) {
        // Simulated method to get city name by ID (replace with actual database query)
        String getCityNameQuery = "SELECT cityName FROM city WHERE cityID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(getCityNameQuery)) {

            statement.setInt(1, cityID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("cityName");
            } else {
                // Handle the case where city is not found
                System.out.println("City not found");
                return null;
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return null;
        }
    }

    ////////////////////////////////////////// Retrieve all city names //////////////////////////////////////////
    public List<String> retrieveCityNames() {
        String retrieveCityNamesQuery = "SELECT cityName FROM city";

        List<String> cityNames = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(retrieveCityNamesQuery); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String cityName = resultSet.getString("cityName");
                cityNames.add(cityName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityNames;
    }

    ////////////////////////////////////////// Retrieve user information using email and password //////////////////////////////////////////
    public User getUserByEmailAndPassword(String email, String password) {
        String getUserQuery = "SELECT * FROM user WHERE userEmailAddress = ? AND userPassword = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(getUserQuery)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                String userFirstName = resultSet.getString("userFirstName");
                String userLastName = resultSet.getString("userLastName");
                String userPhoneNumber = resultSet.getString("userPhoneNumber");
                int userAge = resultSet.getInt("userAge");
                String userRetrievalQuestion = resultSet.getString("userRetrievalQuestion");
                String userRetrievalAnswer = resultSet.getString("userRetrievalAnswer");

                // Get UserStatus from the retrieved string
                String statusString = resultSet.getString("userStatus");
                User.UserStatus userStatus = User.getUserStatusFromString(statusString);

                // Create a User object with retrieved data
                User user = new User(userID, userFirstName, userLastName, email, userPhoneNumber, userAge,
                        password, userStatus, userRetrievalQuestion, userRetrievalAnswer);

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no user found or an error occurred
    }

    ////////////////////////////////////////// Add a new user //////////////////////////////////////////
    public void signUp(String firstName, String lastName, String emailAddress, String phoneNumber,
            int age, String password, UserStatus status, String retrievalQuestion, String retrievalAnswer) {
        // Insert the user into the database
        String insertUserQuery = "INSERT INTO user (userFirstName, userLastName, userEmailAddress, userPhoneNumber, userAge, userPassword, userStatus, userRetrievalQuestion, userRetrievalAnswer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, emailAddress);
            statement.setString(4, phoneNumber);
            statement.setInt(5, age);
            statement.setString(6, password);
            statement.setString(7, status.name());
            statement.setString(8, retrievalQuestion);
            statement.setString(9, retrievalAnswer);

            statement.executeUpdate();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Add flight booking with return flight //////////////////////////////////////////
    public void addReturnFlightBooking(String bookingReference, int numPassengers, float totalFlightPrice, String overallBookingStatus,
            int userID, int classID, int depScheduledFlightID, int retScheduledFlightID, float grandTotal) {
        // Insert the flight booking into the database
        String insertFlightBookingQuery = "INSERT INTO flightBooking (bookingNumber, flightBookingNumPassengers, flightBookingTotalPrice, "
                + "overallBookingStatus, userID, depScheduledFlightID, classID, retScheduledFlightID, grandTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(insertFlightBookingQuery)) {

            statement.setString(1, bookingReference);
            statement.setInt(2, numPassengers);
            statement.setFloat(3, totalFlightPrice);
            statement.setString(4, overallBookingStatus);
            statement.setInt(5, userID);
            statement.setInt(6, depScheduledFlightID);
            statement.setInt(7, classID);
            statement.setInt(8, retScheduledFlightID);
            statement.setFloat(9, grandTotal);

            statement.executeUpdate();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Add flight booking with one way flight //////////////////////////////////////////
    public void addOneWayFlightBooking(String bookingReference, int numPassengers, float totalFlightPrice, String overallBookingStatus,
            int userID, int classID, int depScheduledFlightID, float grandTotal) {
        // Insert the flight booking into the database
        String insertFlightBookingQuery = "INSERT INTO flightBooking (bookingNumber, flightBookingNumPassengers, flightBookingTotalPrice, "
                + "overallBookingStatus, userID, depScheduledFlightID, classID, grandTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(insertFlightBookingQuery)) {

            statement.setString(1, bookingReference);
            statement.setInt(2, numPassengers);
            statement.setFloat(3, totalFlightPrice);
            statement.setString(4, overallBookingStatus);
            statement.setInt(5, userID);
            statement.setInt(6, depScheduledFlightID);
            statement.setInt(7, classID);
            statement.setFloat(8, grandTotal);

            statement.executeUpdate();

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Retrieve cty name using airport name //////////////////////////////////////////
    public String retrieveCityName(String airportName) {
        String cityName = null; // Default value if the airport name is not found

        String sql = "SELECT city.cityName "
                + "FROM airport "
                + "JOIN city ON airport.cityID = city.cityID "
                + "WHERE airport.airportName = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, airportName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cityName = resultSet.getString("cityName");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityName;
    }

    ////////////////////////////////////////// Retrieve hotel ID using city ID //////////////////////////////////////////
    public int retrieveHotelIDByCityID(int cityID) {
        int hotelID = 0; // Default value if the city ID is not found or no hotel is associated

        String sql = "SELECT hotelID FROM hotel WHERE cityID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cityID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    hotelID = resultSet.getInt("hotelID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelID;
    }

    ////////////////////////////////////////// Add hotel booking //////////////////////////////////////////
    public void addHotelBooking(String bookingReference, String checkInDate, String checkOutDate, float hotelCost, String hotelBookingStatus,
            int userID, int hotelID) {
        // Insert the flight booking into the database
        String insertFlightBookingQuery = "INSERT INTO hotelbooking (bookingNumber, hotelBookingCheckInDate, hotelBookingCheckOutDate, "
                + "hotelBookingTotalPrice, hotelBookingStatus, userID, hotelID) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(insertFlightBookingQuery)) {

            statement.setString(1, bookingReference);
            statement.setString(2, checkInDate);
            statement.setString(3, checkOutDate);
            statement.setFloat(4, hotelCost);
            statement.setString(5, hotelBookingStatus);
            statement.setInt(6, userID);
            statement.setInt(7, hotelID);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Hotel and Flight booked successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////// Retrieve hotel booking ID using the booking reference //////////////////////////////////////////
    public int retrieveHotelBookingIDByBookingNumber(String bookingNumber) {
        int hotelBookingID = -1; // Default value if the booking number is not found

        String sql = "SELECT hotelBookingID FROM hotelBooking WHERE bookingNumber = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bookingNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    hotelBookingID = resultSet.getInt("hotelBookingID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelBookingID;
    }

    ////////////////////////////////////////// Retrieve available meal types //////////////////////////////////////////
    public List<MealType> retrieveMealTypes() {
        List<MealType> mealTypes = new ArrayList<>();
        String sql = "SELECT mealTypeID, mealTypeName FROM mealType";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int mealTypeID = resultSet.getInt("mealTypeID");
                String mealTypeName = resultSet.getString("mealTypeName");

                MealType mealType = new MealType(mealTypeID, mealTypeName);
                mealTypes.add(mealType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mealTypes;
    }

    ////////////////////////////////////////// Retrieve available meals by their meal types //////////////////////////////////////////
    public List<Meal> retrieveMealsByType(int mealTypeID) {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT mealID, mealName, mealDescription, mealPrice FROM meal WHERE mealTypeID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, mealTypeID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int mealID = resultSet.getInt("mealID");
                    String mealName = resultSet.getString("mealName");
                    String mealDescription = resultSet.getString("mealDescription");
                    double mealPrice = resultSet.getDouble("mealPrice");

                    Meal meal = new Meal(mealID, mealName, mealDescription, mealPrice);
                    meals.add(meal);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meals;
    }

    ////////////////////////////////////////// Retrieve an airport ID using the airport name //////////////////////////////////////////
    public int retrieveAirportID(String airportName) {
        int airportID = 0;
        String sql = "SELECT airportID FROM airport WHERE airportName = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, airportName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    airportID = resultSet.getInt("airportID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return airportID;
    }

    ////////////////////////////////////////// Retrieve an aircraft ID using the aircraft name //////////////////////////////////////////
    public int retrieveAircraftID(String aircraftName) {
        int aircraftID = 0;
        String sql = "SELECT aircraftID FROM aircraft WHERE aircraftName = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, aircraftName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    aircraftID = resultSet.getInt("aircraftID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aircraftID;
    }

    ////////////////////////////////////////// Get Booked Flights for a User //////////////////////////////////////////
    public DefaultTableModel getBookedFlightsForUser(int userID) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Booking Reference");
        tableModel.addColumn("Departure Airport");
        tableModel.addColumn("Arrival Airport");
        tableModel.addColumn("Departure Date");
        tableModel.addColumn("Arrival Date");
        tableModel.addColumn("Number of Passengers");
        tableModel.addColumn("Flight Amount Paid");
        tableModel.addColumn("Has Hotel Booking");
        tableModel.addColumn("Hotel Amount Paid");
        tableModel.addColumn("Booking Status");

        String sql = "SELECT "
                + "fb.bookingNumber, "
                + "(SELECT airportName FROM airport WHERE airportID = depSF.departureAirportID) AS departureAirport, "
                + "(SELECT airportName FROM airport WHERE airportID = arrSF.arrivalAirportID) AS arrivalAirport, "
                + "depSF.scheduledFlightDepartureDate, "
                + "arrSF.scheduledFlightArrivalDate, "
                + "fb.flightBookingNumPassengers, "
                + "fb.flightBookingTotalPrice AS flightAmountPaid, "
                + "CASE WHEN hb.bookingNumber IS NOT NULL THEN 'Yes' ELSE 'No' END AS hasHotelBooking, "
                + "COALESCE(hb.hotelBookingTotalPrice, 0) AS hotelAmountPaid, "
                + "fb.overallBookingStatus "
                + "FROM "
                + "flightBooking fb "
                + "JOIN "
                + "scheduledflight depSF ON fb.depScheduledFlightID = depSF.scheduledFlightID "
                + "JOIN "
                + "scheduledflight arrSF ON fb.retScheduledFlightID = arrSF.scheduledFlightID "
                + "LEFT JOIN "
                + "hotelBooking hb ON fb.bookingNumber = hb.bookingNumber "
                + "WHERE "
                + "fb.userID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String bookingNumber = resultSet.getString("bookingNumber");
                    String departureAirport = resultSet.getString("departureAirport");
                    String arrivalAirport = resultSet.getString("arrivalAirport");
                    System.out.println("Departure Airport: " + departureAirport);
                    System.out.println("Arrival Airport: " + arrivalAirport);
                    String departureDate = resultSet.getString("scheduledFlightDepartureDate");
                    String arrivalDate = resultSet.getString("scheduledFlightArrivalDate");
                    int numPassengers = resultSet.getInt("flightBookingNumPassengers");
                    double flightAmountPaid = resultSet.getDouble("flightAmountPaid");
                    String hasHotelBooking = resultSet.getString("hasHotelBooking");
                    double hotelAmountPaid = resultSet.getDouble("hotelAmountPaid");
                    String status = resultSet.getString("overallBookingStatus");

                    Object[] rowData = {bookingNumber, departureAirport, arrivalAirport, departureDate, arrivalDate,
                        numPassengers, flightAmountPaid, hasHotelBooking, hotelAmountPaid, status};
                    tableModel.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableModel;
    }

    ////////////////////////////////////////// Check if an inserted booking reference exists //////////////////////////////////////////
    public boolean isBookingNumberExists(String bookingNumber) throws SQLException {
        String sql = "SELECT COUNT(*) FROM flightBooking WHERE bookingNumber = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bookingNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    ////////////////////////////////////////// Retrieve a Booked Departure Flight using the booking reference //////////////////////////////////////////
    public DepartureFlight retrieveFlightBookingInfo(String bookingNumber) throws SQLException {
        DepartureFlight departureFlight = null;
        String sql = "SELECT sf.* FROM flightbooking fb "
                + "JOIN scheduledflight sf ON fb.depScheduledFlightID = sf.scheduledFlightID "
                + "WHERE fb.bookingNumber = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bookingNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract necessary information from the result set
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

                    // Create a DepartureFlight object with the extracted information
                    departureFlight = new DepartureFlight(
                            scheduledFlightID, scheduledFlightPrice, scheduledFlightDepartureDate,
                            scheduledFlightDepartureTime, scheduledFlightArrivalDate, scheduledFlightArrivalTime,
                            scheduledFlightStatus, departureAirportID, arrivalAirportID, aircraftID
                    );
                }
            }
        }

        return departureFlight;
    }

    ////////////////////////////////////////// Check if a hotel booking was made using the booking reference //////////////////////////////////////////
    public boolean isHotelBookingExists(String bookingNumber) throws SQLException {
        String sql = "SELECT COUNT(*) FROM hotelBooking WHERE bookingNumber = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bookingNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    ////////////////////////////////////////// Retrieve cty name using airport ID //////////////////////////////////////////
    public String retrieveCityName(int airportID) {
        String cityName = null; // Default value if the airport name is not found

        String sql = "SELECT city.cityName "
                + "FROM airport "
                + "JOIN city ON airport.cityID = city.cityID "
                + "WHERE airport.airportID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, airportID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cityName = resultSet.getString("cityName");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityName;
    }

    ////////////////////////////////////////// Update aircraft status with aircraft ID and the new status //////////////////////////////////////////
    public void updateAircraftStatus(int aircraftID, String newStatus) {
        System.out.println("Updating status for Aircraft ID: " + aircraftID);
        String sql = "UPDATE aircraft SET aircraftStatus = ? WHERE aircraftID = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, aircraftID);

            // Print the SQL query for debugging
            System.out.println("SQL Query: " + preparedStatement.toString());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Display a JOptionPane message for successful update
                JOptionPane.showMessageDialog(null, "Aircraft status updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Display a JOptionPane message for unsuccessful update
                JOptionPane.showMessageDialog(null, "Failed to update aircraft status.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
