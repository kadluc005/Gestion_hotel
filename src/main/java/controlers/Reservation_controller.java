/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Reservation_model;

/**
 *
 * @author hp
 */
public class Reservation_controller {
    
    public static void ajouter_reservation(Reservation_model md){
        
        try(Connection conn =  DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO reservation (date_arrivee, date_depart, id_client, id_chambre, etat_reservation) VALUES (?,?,?,?,?);")){
            
            stmt.setString(1, md.getDate_arrivee());
            stmt.setString(2,md.getDate_depart());
            stmt.setInt(3, md.getId_client());
            stmt.setInt(4, md.getId_chambre());
            stmt.setString(5, md.getEtat_reservation());
            
            int  rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Ajouté avec succès");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void modifier_reservation(Reservation_model md, String id_reserv){
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE reservation SET date_arrivee = ?, date_depart = ?, id_client = ?, id_chambre = ?, etat_reservation = ? WHERE id_reservation = ?;")){
            
            stmt.setString(1,md.getDate_arrivee());
            stmt.setString(2, md.getDate_depart());
            stmt.setInt(3, md.getId_client());
            stmt.setInt(4, md.getId_chambre());
            stmt.setString(5, md.getEtat_reservation());
            stmt.setString(6, id_reserv);
            
            int  rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Modifié avec succès");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la modification");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void supprimer_reservation(String id_reserv){
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM reservation WHERE id_reservation = ?;")){
            
            stmt.setString(1,id_reserv);
            
            int rowsAffected = 0;
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer?", "Supprimer", JOptionPane.YES_NO_OPTION);
            if(choix == JOptionPane.YES_OPTION){
                rowsAffected = stmt.executeUpdate();
            }
            
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Supprimé avec succès");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
