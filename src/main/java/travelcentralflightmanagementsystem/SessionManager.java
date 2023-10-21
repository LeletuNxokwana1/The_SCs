/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

/**
 *
 * @author the_scs
 */

public class SessionManager {
    private static User loggedInUser; // Assuming User is the class representing your user

    // Private constructor to prevent instantiation
    private SessionManager() {
    }

    public static void login(User user) {
        loggedInUser = user;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }
    
    public static String getLoggedInUsername() {
        if (loggedInUser != null) {
            return loggedInUser.getFirstName() + " " + loggedInUser.getLastName();
        }
        return null;
    }

}
