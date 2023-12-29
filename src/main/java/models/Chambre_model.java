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
    private String  situation_chambre;
    private String  localisation;
    private float  prix_chambre;

    public Chambre_model(String type_chambre, String situation_chambre, String localisation, float prix_chambre) {
        this.type_chambre = type_chambre;
        this.situation_chambre = situation_chambre;
        this.localisation = localisation;
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

    public String getSituation_chambre() {
        return situation_chambre;
    }

    public void setSituation_chambre(String stuation_chambre) {
        this.situation_chambre = situation_chambre;
    }
    
    public String getLocalisation(){
        return localisation;
    }
    
    public void setLocalisation(String localisation){
        this.localisation = localisation;
    }

    public float getPrix_chambre() {
        return prix_chambre;
    }

    public void setPrix_chambre(float prix_chambre) {
        this.prix_chambre = prix_chambre;
    }
    
    
    
    
}
