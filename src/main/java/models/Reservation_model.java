/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hp
 */
public class Reservation_model {
    private String date_arrivee ;
    private String date_depart ;
    private int id_client ;
    private int id_chambre ;
    private String etat_reservation; 	

    public Reservation_model(String date_arrivee, String date_depart, int id_client, int id_chambre, String etat_reservation) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.id_client = id_client;
        this.id_chambre = id_chambre;
        this.etat_reservation = etat_reservation;
    }
    
    public Reservation_model(){
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public String getEtat_reservation() {
        return etat_reservation;
    }

    public void setEtat_reservation(String etat_reservation) {
        this.etat_reservation = etat_reservation;
    }
    
}
