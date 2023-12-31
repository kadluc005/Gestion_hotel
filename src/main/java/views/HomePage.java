/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import views.panels.EventMenuSelected;
import views.selectedItems.*;


/**
 *
 * @author hp
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    private Client_view cl = new Client_view();
    private Chambre_view ch = new Chambre_view();
    private Chambre_view_admin cha = new Chambre_view_admin();
    private Reservation_view rsvt = new Reservation_view();
    private Paiement_view pmt = new Paiement_view();
    private Divers_view dvrs = new Divers_view();
    private Admin_view admin = new Admin_view();
    
    public HomePage() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        //NavPanel.iniMoving(HomePage.this);
        //this.setExtendedState(HomePage.MAXIMIZED_BOTH);
        navPanel.addEventMenuSelected(new EventMenuSelected(){
            @Override
            public void selected(int index) {
                if(index == 0){
                    
                }else if(index == 1){
                    setForm(cl);
                }else if(index == 2){
                    setForm(ch);
                }else if(index == 3){
                    setForm(rsvt);
                }else if(index == 4){
                    setForm(pmt);
                }else if(index == 5){
                    setForm(cha);
                }else if(index == 6){
                    JPasswordField admin_mdp = new JPasswordField();

                    int option = JOptionPane.showConfirmDialog(null, admin_mdp, "Entrez le mot de passe administrateur", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if(option == JOptionPane.OK_OPTION){
                        if(admin_mdp.getText().equals("00")){
                            setForm(admin);
                        }else{
                            JOptionPane.showMessageDialog(null, "Le mot de passe est erroné");
                        }
                    } 
                }else if(index == 8){
                    int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment vous déconnecter?", "Déconnexion", JOptionPane.YES_NO_OPTION);
                    if(choix == JOptionPane.YES_OPTION){
                        HomePage.super.dispose();
                        Login lg = new Login();
                        lg.setVisible(true);
                    }
                }
            }
        });
        setForm(new Client_view());
    }
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.revalidate();
        mainPanel.repaint();     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel2 = new views.panels.BasePanel();
        navPanel = new views.panels.NavPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        basePanel2.setBackground(new java.awt.Color(255, 255, 255));

        navPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navPanelMouseClicked(evt);
            }
        });

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout basePanel2Layout = new javax.swing.GroupLayout(basePanel2);
        basePanel2.setLayout(basePanel2Layout);
        basePanel2Layout.setHorizontalGroup(
            basePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanel2Layout.createSequentialGroup()
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basePanel2Layout.setVerticalGroup(
            basePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void navPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_navPanelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private views.panels.BasePanel basePanel2;
    public javax.swing.JPanel mainPanel;
    private views.panels.NavPanel navPanel;
    // End of variables declaration//GEN-END:variables
}
