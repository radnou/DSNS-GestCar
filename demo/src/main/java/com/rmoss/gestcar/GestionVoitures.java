package com.rmoss.gestcar;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionVoitures {
    private ArrayList<Voiture> voitures;
    private ArrayList<Location> locations;

    public GestionVoitures() {
        this.voitures = new ArrayList<>();
        this.locations = new ArrayList<>();
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

    // Afficher toutes les voitures disponibles
    public void afficherVoituresDisponibles() {
        for (Voiture voiture : voitures) {
            if (voiture.isDisponible()) {
                voiture.afficherInfo();
            }
        }
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
}
