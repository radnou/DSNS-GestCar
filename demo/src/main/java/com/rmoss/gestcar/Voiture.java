package com.rmoss.gestcar;


/**
 * Classe abstraite représentant une voiture.
 * Ne peut pas être instanciée directement, doit être étendue par des sous-classes spécifiques.
 */
public abstract class Voiture {

    protected String marque;
    protected String modele;
    protected Integer annee;
    protected Double prixParJour;
    protected boolean estDisponible;

    public Voiture(String marque, String modele, Integer annee, Double prixParJour) {
        this.marque = marque;
        this.annee = annee;
        this.modele = modele;
        this.prixParJour = prixParJour;
        this.estDisponible = true; // Par défaut, une voiture est disponible
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getAnnee() {
        return this.annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Double getPrixParJour() {
        return this.prixParJour;
    }

    public void setPrixParJour(Double prixParJour) {
        this.prixParJour = prixParJour;
    }

        // Getters et setters
        public boolean isDisponible() {
            return estDisponible;
        }
    
        public void setDisponible(boolean estDisponible) {
            this.estDisponible = estDisponible;
        }
 /**
     * Méthode abstraite à implémenter par les sous-classes pour afficher les détails spécifiques.
     */
    public abstract void afficherInfo();

    /**
     * Méthode abstraite à implémenter par les sous-classes pour calculer la consommation.
     */
    public abstract double calculerConsommation();
}