package com.rmoss.gestcar;

import java.util.ArrayList;

public class GestionVoitures {
 private ArrayList<Voiture> voitures;

    public GestionVoitures() {
        this.voitures = new ArrayList<>();
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
}
