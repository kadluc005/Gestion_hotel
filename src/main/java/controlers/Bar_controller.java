 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Bar_controller {
    
    public int getQuantite(String id) {
        int result = 0;
        try (Connection conn = DbConnection.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement("SELECT quantite_boisson  FROM boissons WHERE id_boisson = ?;")) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static void updateQuantite(String id, int qte){
        String sql="UPDATE boissons SET quantite_boisson = ? WHERE id_boisson = ?;";
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement stmt=conn.prepareStatement(sql)){
            
            stmt.setInt(1,qte);
            stmt.setString(2, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected>0){
                JOptionPane.showMessageDialog(null, "Commandé");
            }else{
                JOptionPane.showMessageDialog(null,"Erreur lors de la commande");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String getClientName(String id) {
        String result = "";
        try (Connection conn = DbConnection.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement("SELECT nom_client, prenom_client  FROM clients WHERE id_client = ?;")) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
