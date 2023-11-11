/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hp
 */
public class Chambre_model {
    private String  type_chambre;
    private String  stuation_chambre;
    private float  prix_chambre;

    public Chambre_model(String type_chambre, String stuation_chambre, float prix_chambre) {
        this.type_chambre = type_chambre;
        this.stuation_chambre = stuation_chambre;
        this.prix_chambre = prix_chambre;
    }
    
    public Chambre_model(){
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public String getStuation_chambre() {
        return stuation_chambre;
    }

    public void setStuation_chambre(String stuation_chambre) {
        this.stuation_chambre = stuation_chambre;
    }

    public float getPrix_chambre() {
        return prix_chambre;
    }

    public void setPrix_chambre(float prix_chambre) {
        this.prix_chambre = prix_chambre;
    }
    
    
    
    
}
