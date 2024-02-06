/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Blob;

/**
 *
 * @author hp
 */
public class Client_model {
    private String nom_client;
    private String prenom_client;
    private String tel_client;
    private String pays_client;
    private String categorie_client;
    private String carte_fidelité;

    public Client_model(String nom_client, String prenom_client, String tel_client, String pays_client, String categorie_client, String carte_fidelité) {
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.tel_client = tel_client;
        this.pays_client = pays_client;
        this.categorie_client = categorie_client;
        this.carte_fidelité = carte_fidelité;
    }
    
    public Client_model(){
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getTel_client() {
        return tel_client;
    }

    public void setTel_client(String tel_client) {
        this.tel_client = tel_client;
    }

    public String getPays_client() {
        return pays_client;
    }

    public void setPays_client(String pays_client) {
        this.pays_client = pays_client;
    }

    public String getCategorie_client() {
        return categorie_client;
    }

    public void setCategorie_client(String categorie_client) {
        this.categorie_client = categorie_client;
    }

    public String getCarte_fidelité() {
        return carte_fidelité;
    }

    public void setCarte_fidelité(String carte_fidelité) {
        this.carte_fidelité = carte_fidelité;
    }

}
