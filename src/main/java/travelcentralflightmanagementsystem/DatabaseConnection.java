/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package travelcentralflightmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author the_scs
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travelcentral";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "b!Q204XaPaFi";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
