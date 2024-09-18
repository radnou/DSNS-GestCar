package com.rmoss.gestcar.model;

/**
 * Classe représentant un client.
 */
public class Client {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;

    public Client(int id ,String nom, String adresse, String telephone) {
        this.id = id;
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

    public Client setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Client setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Client setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}