package com.rmoss.gestcar;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Application de Gestion de Véhicules");
        // Création d'une instance de gestion des voitures
        GestionVoitures gestionVoitures = new GestionVoitures();

        // Ajout de deux voitures
        VoitureThermique voitureToyota = new VoitureThermique("Toyota", "Corolla", 2020, 6, 5);
        VoitureThermique voitureHonda = new VoitureThermique("Honda", "Civic", 2019, 54, 4.5);
        VoitureElectrique voitureElectrique = new VoitureElectrique("Tesla", "Model S", 2022, 120.0, 450);
        Voiture renaultMegane = new VoitureThermique("Renault", "Megane", 2018, 40.0, 99.9);

        gestionVoitures.ajouterVoiture(voitureToyota);
        gestionVoitures.ajouterVoiture(voitureHonda);
        gestionVoitures.ajouterVoiture(voitureElectrique);
        gestionVoitures.ajouterVoiture(renaultMegane);

        // Afficher toutes les voitures
        System.out.println("Liste des voitures disponibles :");
        gestionVoitures.afficherVoitures();       

        // Création d'un client
        Client client = new Client("Emmanuel Macron", "123 Rue des Fleurs", "0123456789");

        // Louer une voiture thermique
        gestionVoitures.louerVoiture(renaultMegane, client, LocalDate.now(), LocalDate.now().plusDays(3));

        // Afficher les voitures disponibles après location
        System.out.println("\nVoitures disponibles après location:");
        gestionVoitures.afficherVoituresDisponibles();

        // Afficher l'historique des locations
        System.out.println("\nHistorique des locations:");
        gestionVoitures.afficherHistoriqueLocations();
        // Ajouter un client depuis la console
    gestionVoitures.ajouterClientDepuisConsole();

    // Louer une voiture depuis la console
    Client client2 = gestionVoitures.getClients().get(0); // Sélection du premier client pour simplifier

    // Ajouter et afficher des voitures comme avant, puis louer depuis la console
    VoitureThermique voiture = new VoitureThermique("Renault", "Clio", 2020, 50.0, 6.2);
    gestionVoitures.ajouterVoiture(voiture);

    LocalDate dateDebut = gestionVoitures.saisirDateDepuisConsole("Entrez la date de début (yyyy-MM-dd) : ");
    LocalDate dateFin = gestionVoitures.saisirDateDepuisConsole("Entrez la date de fin (yyyy-MM-dd) : ");

    gestionVoitures.louerVoiture(voiture, client, dateDebut, dateFin);
    }
}
