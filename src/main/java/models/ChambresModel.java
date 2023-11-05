/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ChambresModel {
    String url = "jdbc:mysql://localhost:3306/gestionhotel";
    String username = "root";
    String password = null;
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    public void AjoutertChambre(){
        String sql = "INSERT INTO chambres (nom_client, prenom_client, tel_client, categorie_client, carte_fidelite, pays_client) VALUES(?,?,?,?,?,?);";
        
        try(Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            String name = null;
            
            stmt.setString(1,name);
            stmt.setString(2,name);
            stmt.setString(3,name);
            stmt.setString(4,name);
            stmt.setString(5,name);
            stmt.setString(6,name);
            
            int rowsAffected=stmt.executeUpdate();
            if(rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Utilisateur ajouté avec succè");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void modifierChambre(){
        
    }
    
    public void supprimerChambre(){
        
    }
}
