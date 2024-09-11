package com.rmoss.gestcar;

public class Voiture {

    private String marque;
    private String modele;
    private Integer annee;
    private Double prixParJour;

    public Voiture(String marque, String modele, Integer annee, Double prixParJour) {
        this.marque = marque;
        this.annee = annee;
        this.modele = modele;
        this.prixParJour = prixParJour;
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

      // Afficher les informations de la voiture
      public void afficherInfo() {
        System.out.println("Voiture : " + marque + " " + modele + " (" + annee + "), Prix par jour : " + prixParJour);
    }
}