/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Chambre_model;
import views.selectedItems.Chambre_view_admin;

/**
 *
 * @author hp
 */
public class Chambre_controller {
    
    public static void ajouterChambre(Chambre_model ch){
        try(Connection conn =  DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO chambres (type_chambre, situation_chambre, prix_chambre) VALUES (?,?,?);")){
            
            stmt.setString(1, ch.getType_chambre());
            stmt.setString(2,ch.getSituation_chambre());
            stmt.setFloat(3, ch.getPrix_chambre());
            
            int  rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                new Chambre_view_admin().tablech();
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    } 

    public static void modifierChambre(Chambre_model ch, String id_ch){
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE chambres SET type_chambre = ?, situation_chambre = ?, prix_chambre = ? WHERE id_chambre = ?;")){
            
            stmt.setString(1, ch.getType_chambre());
            stmt.setString(2, ch.getSituation_chambre());
            stmt.setFloat(3,ch.getPrix_chambre());
            stmt.setString(4,id_ch);
            
            
            int rowsAffected = 0;
            int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier?", "Modifier", JOptionPane.YES_NO_OPTION);
            if(choix == JOptionPane.YES_OPTION){
                rowsAffected=stmt.executeUpdate();
                new Chambre_view_admin().tablech();
            }
             new Chambre_view_admin().tablech();
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Modifié avec succès", "Succès",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la modification");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void supprimerChambre(String id_ch){
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM chambres WHERE id_chambre = ?")){
            stmt.setString(1, id_ch);
            
            int rowsAffected = 0;
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer?", "Supprimer", JOptionPane.YES_NO_OPTION);
            if(choix == JOptionPane.YES_OPTION){
                rowsAffected = stmt.executeUpdate();
                new Chambre_view_admin().tablech();
            }
            
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Supprimé avec succès");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
