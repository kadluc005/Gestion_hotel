/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;
import java.sql.*;
import javax.swing.JOptionPane;
import models.Users_model;

/**
 *
 * @author hp
 */
public class Users_controller {
    
    public static void add_user(Users_model us){
        String sql = "INSERT INTO users (username, userpassword) VALUES(?,?);";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, us.getUsername());
            stmt.setString(2, us.getPassword());
            
            int rowsAffected=stmt.executeUpdate();
          
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Ajouté avec succès");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void update_user(Users_model us, String id_user){
        String sql = "UPDATE users SET username = ?, userpassword = ? WHERE id_user = ?;";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, us.getUsername());
            stmt.setString(2, us.getPassword());
            stmt.setString(3,id_user);
            
            int rowsAffected=stmt.executeUpdate();
          
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Modifié avec succès");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la modification");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void delete_user(String id_user){
        String sql = "DELETE FROM users WHERE id_user = ?;";
        
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,id_user);
            
            int rowsAffected = 0;
            int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer?", "Supprimer", JOptionPane.YES_NO_OPTION);
            if(choix == JOptionPane.YES_OPTION){
                rowsAffected=stmt.executeUpdate();
            }
          
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Supprimé avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la suppression");
            }
            
        }catch(SQLException e){
            
        }
    }
    
}
