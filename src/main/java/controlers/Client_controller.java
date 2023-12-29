/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Client_model;

/**
 *
 * @author hp
 */
public class Client_controller {
    
    public static void ajouterClient(Client_model cl){
        String sql="INSERT INTO clients (nom_client, prenom_client, tel_client, pays_client, categorie_client, carte_fidelite) VALUES (?,?,?,?,?,?); ";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt=conn.prepareStatement(sql)){
            
            stmt.setString(1,cl.getNom_client());
            stmt.setString(2,cl.getPrenom_client());
            stmt.setString(3,cl.getTel_client());
            stmt.setString(4,cl.getPays_client());
            stmt.setString(5,cl.getCategorie_client());
            stmt.setString(6,cl.getCarte_fidelité());
            
            int rowsAffected=stmt.executeUpdate();
          
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Ajouté avec succès");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout");
            }
            
        }catch(Exception e){
            System.out.println("Erreur lors de l'ajout "+e.getMessage());
        }
    }
    
    public static void modifierClient(Client_model cl, String txt_id){
        String sql="UPDATE clients SET nom_client = ?, prenom_client = ?, tel_client = ?, pays_client = ?, categorie_client = ?, carte_fidelite = ? WHERE id_client = ?;";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt=conn.prepareStatement(sql)){
            
            stmt.setString(1,cl.getNom_client());
            stmt.setString(2,cl.getPrenom_client());
            stmt.setString(3,cl.getTel_client());
            stmt.setString(4,cl.getPays_client());
            stmt.setString(5,cl.getCategorie_client());
            stmt.setString(6,cl.getCarte_fidelité());
            stmt.setString(7, txt_id);
   
            int rowsAffected = 0;
            int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier?", "Modifier", JOptionPane.YES_NO_OPTION);
            if(choix == JOptionPane.YES_OPTION){
                rowsAffected=stmt.executeUpdate();
            }
            
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null,"Modifié avec succès", "Succès" , JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la modification");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout "+e.getMessage());
        }
    }
    public static void supprimerClient(String txt_id){
        String sql="DELETE FROM clients WHERE id_client = ?; ";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt=conn.prepareStatement(sql)){
            
            stmt.setString(1,txt_id);
            
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
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout "+e.getMessage());
        }
    }
    
}
