package com.rmoss.gestcar.controller;

public class VoitureElectriqueController {
    private final VoitureElectriqueDAO voitureElectriqueDAO;
    private final VoitureView vue;

    public VoitureElectriqueController(VoitureElectriqueDAO voitureElectriqueDAO, VoitureView vue) {
        this.voitureElectriqueDAO = voitureElectriqueDAO;
        this.vue = vue;
    }

    public void ajouterVoitureElectrique(VoitureElectrique voitureElectrique) {
        try {
            voitureElectriqueDAO.ajouterVoitureElectrique(voitureElectrique);
            vue.afficherMessage("Voiture électrique ajoutée avec succès !");
        } catch (SQLException e) {
            vue.afficherErreur("Erreur lors de l'ajout de la voiture électrique : " + e.getMessage());
        }
    }

    public void afficherVoitureElectrique(int id) {
        try {
            VoitureElectrique voiture = voitureElectriqueDAO.obtenirVoitureElectriqueParId(id);
            if (voiture != null) {
                vue.afficherDetailsVoiture(voiture.getMarque(), voiture.getModele(), voiture.getAnnee(), voiture.getAutonomieBatterie(), voiture.getPrixParJour());
            } else {
                vue.afficherErreur("Voiture électrique non trouvée.");
            }
        } catch (SQLException e) {
            vue.afficherErreur("Erreur lors de la récupération de la voiture électrique : " + e.getMessage());
        }
    }
}
