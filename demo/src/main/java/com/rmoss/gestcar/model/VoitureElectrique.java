package com.rmoss.gestcar.model;

public class VoitureElectrique extends Voiture {
    private int autonomieBatterie; // en kilomètres

    // Constructeur
    public VoitureElectrique(String marque, String modele, int annee, double prixParJour, int autonomieBatterie) {
        super(marque, modele, annee, prixParJour);
        this.autonomieBatterie = autonomieBatterie;
    }

    // Getters et Setters
    public int getAutonomieBatterie() {
        return autonomieBatterie;
    }

    public void setAutonomieBatterie(int autonomieBatterie) {
        this.autonomieBatterie = autonomieBatterie;
    }

    /**
     * Affiche les informations spécifiques d'une voiture électrique.
     */
    @Override
    public void afficherInfo() {
        System.out.println("Voiture Électrique : " + marque + " " + modele + " (" + annee + ")");
        System.out.println("Autonomie de la batterie : " + autonomieBatterie + " km");
    }

    /**
     * Calcule l'autonomie de la batterie d'une voiture électrique.
     */
    @Override
    public double calculerConsommation() {
        return autonomieBatterie / 100.0; // formule simplifiée pour calculer la consommation
    }

}