package com.rmoss.gestcar;

import com.rmoss.gestcar.model.Client;
import com.rmoss.gestcar.model.Location;
import com.rmoss.gestcar.model.Voiture;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVoitures {
    private final ArrayList<Voiture> voitures;
    private final ArrayList<Location> locations;
    private final ArrayList<Client> clients; // Ajout de la gestion des clients

    public GestionVoitures() {
        this.voitures = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>(); // Initialisation de la liste des clients
    }

    // Ajouter un client à la liste
    public void ajouterClient(Client client) {
        clients.add(client);
    }

    // Afficher tous les clients
    public void afficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
        } else {
            System.out.println("Liste des clients :");
            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                System.out.println((i + 1) + ". " + client.getNom() + " (" + client.getTelephone() + ")");
            }
        }
    }

    // Ajouter une voiture à la liste
    public void ajouterVoiture(Voiture voiture) {
        voitures.add(voiture);
    }

    // Afficher toutes les voitures
    public void afficherVoitures() {
        for (Voiture voiture : voitures) {
            voiture.afficherInfo();
        }
    }

    // Rechercher une voiture par marque
    public Voiture rechercherVoitureParMarque(String marque) {
        for (Voiture voiture : voitures) {
            if (voiture.getMarque().equalsIgnoreCase(marque)) {
                return voiture;
            }
        }
        return null; // Si aucune voiture n'est trouvée
    }

    public void afficherVoituresDisponibles() {
        System.out.println("\n+----------------------------+");
        System.out.println("| Voitures disponibles        |");
        System.out.println("+----------------------------+");
        boolean aDesVoitures = false;
        for (Voiture voiture : voitures) {
            if (voiture.isDisponible()) {
                voiture.afficherInfo();
                aDesVoitures = true;
            }
        }
        if (!aDesVoitures) {
            System.out.println("Aucune voiture n'est disponible.");
        }
        System.out.println("+----------------------------+\n");
    }

    // Vérifier si une voiture fait partie du parc géré
    private boolean voitureEstDansLeParc(Voiture voiture) {
        return voitures.contains(voiture);
    }

    // Louer une voiture
    public void louerVoiture(Voiture voiture, Client client, LocalDate dateDebut, LocalDate dateFin) {
        // Vérification si la voiture fait partie du parc
        if (!voitureEstDansLeParc(voiture)) {
            System.out.println("La voiture spécifiée ne fait pas partie du parc de voitures disponibles.");
            return;
        }
        // Vérification de la disponibilité
        if (voiture.isDisponible()) {
            Location nouvelleLocation = new Location(voiture, client, dateDebut, dateFin);
            locations.add(nouvelleLocation);
            voiture.setDisponible(false); // La voiture n'est plus disponible
            System.out.println("La voiture a été louée avec succès.");
            nouvelleLocation.afficherDetailsLocation();
        } else {
            System.out.println("La voiture n'est pas disponible pour la location.");
        }
    }

    // Afficher l'historique des locations
    public void afficherHistoriqueLocations() {
        for (Location location : locations) {
            location.afficherDetailsLocation();
        }
    }

    public void ajouterClientDepuisConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n+----------------------------+");
        System.out.println("| Ajouter un nouveau client   |");
        System.out.println("+----------------------------+");

        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();

        System.out.print("Entrez le numéro de téléphone du client : ");
        String telephone = scanner.next();

        Client client = new Client(nom, adresse, telephone);
        ajouterClient(client);

        System.out.println("Client ajouté avec succès : " + nom + "\n");
    }

    public LocalDate saisirDateDepuisConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        String dateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter);
    }

    public ArrayList<Client> getClients() {
        return this.clients;
    }
}
