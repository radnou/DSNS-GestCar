package com.rmoss.gestcar.model;

/**
 * Classe représentant un client.
 */
public class Client {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;

    public Client(String nom, String adresse, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }
}