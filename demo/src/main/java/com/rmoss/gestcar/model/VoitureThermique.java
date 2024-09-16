package com.rmoss.gestcar.model;

/**
 * Classe représentant une voiture thermique, étendant la classe abstraite
 * Voiture.
 */
public class VoitureThermique extends Voiture {
    private double consommationCarburant; // en litres/100 km

    public VoitureThermique(String marque, String modele, int annee, double prixParJour, double consommationCarburant) {
        super(marque, modele, annee, prixParJour);
        this.consommationCarburant = consommationCarburant;
    }

    // Getters et Setters
    public double getConsommationCarburant() {
        return consommationCarburant;
    }

    public void setConsommationCarburant(double consommationCarburant) {
        this.consommationCarburant = consommationCarburant;
    }

    // Méthode surchargée pour afficher seulement la consommation
    /**
     * Affiche les informations détaillées de la voiture thermique. Surcharge de la
     * méthode afficherInfo pour inclure la consommation de carburant.
     * 
     * @param uniquementConsommation si true, n'affiche que la consommation.
     */
    public void afficherInfo(boolean uniquementConsommation) {
        if (uniquementConsommation) {
            System.out.println("Consommation carburant : " + consommationCarburant + " litres/100 km");
        } else {
            afficherInfo(); // Appelle la méthode redéfinie
        }
    }

    /**
     * Affiche les informations spécifiques d'une voiture thermique.
     */
    @Override
    public void afficherInfo() {
        System.out.println("Voiture Thermique : " + marque + " " + modele + " (" + annee + ")");
        System.out.println("Consommation carburant : " + consommationCarburant + " litres/100 km");
    }

    /**
     * Calcule la consommation en carburant d'une voiture thermique.
     */
    @Override
    public double calculerConsommation() {
        return consommationCarburant;
    }
}
