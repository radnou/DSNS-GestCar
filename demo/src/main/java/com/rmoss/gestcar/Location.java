package com.rmoss.gestcar;

import java.time.LocalDate;

/**
 * Classe représentant une location de voiture.
 */
public class Location {
    private Voiture voiture;
    private Client client;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Constructeur
    public Location(Voiture voiture, Client client, LocalDate dateDebut, LocalDate dateFin) {
        this.voiture = voiture;
        this.client = client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Calcul du coût total de la location en fonction du nombre de jours.
     */
    public double calculerCoutTotal() {
        long nombreJours = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
        return nombreJours * voiture.getPrixParJour();
    }

    /**
     * Afficher les détails de la location.
     */
    public void afficherDetailsLocation() {
        long nombreJours = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
        System.out.println("Location:");
        System.out.println("Client: " + client.getNom());
        System.out.println("Voiture: " + voiture.getMarque() + " " + voiture.getModele());
        System.out.println("Date de début: " + dateDebut);
        System.out.println("Date de fin: " + dateFin);
        System.out.println("Nombre de jours de location: " + nombreJours);
        System.out.println("Coût total: " + calculerCoutTotal() + " €");
    }
}