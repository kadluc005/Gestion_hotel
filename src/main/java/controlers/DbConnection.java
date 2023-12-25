/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;
import java.sql.*;

/**
 *
 * @author hp
 */
public class DbConnection {


    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hoteldb";
        String username = "root";
         String password = "";
        return DriverManager.getConnection(url, username, password);
    }
}
