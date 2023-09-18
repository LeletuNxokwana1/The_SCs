/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexairportmanagement;

/**
 *
 * @author lelet
 */
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static SessionManager instance;
    private Map<String, Object> sessionData;

    private SessionManager() {
        sessionData = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void storeLoggedInUser(String email) {
        // Store user-specific data in the session
        sessionData.put("loggedInUser", email);
    }

    public String getLoggedInUser() {
        // Retrieve user-specific data from the session
        return (String) sessionData.get("loggedInUser");
    }

    // Other session-related methods can go here
}
