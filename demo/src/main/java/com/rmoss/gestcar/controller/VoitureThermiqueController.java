package com.rmoss.gestcar.controller;

import com.rmoss.gestcar.dao.VoitureThermiqueDAO;
import com.rmoss.gestcar.model.VoitureThermique;
import com.rmoss.gestcar.view.VoitureView;

import java.sql.SQLException;

public class VoitureThermiqueController {
    private final VoitureThermiqueDAO voitureThermiqueDAO;
    private final VoitureView vue;

    public VoitureThermiqueController(VoitureThermiqueDAO voitureThermiqueDAO, VoitureView vue) {
        this.voitureThermiqueDAO = voitureThermiqueDAO;
        this.vue = vue;
    }

    public void ajouterVoitureThermique(VoitureThermique voitureThermique) {
        try {
            voitureThermiqueDAO.ajouterVoitureThermique(voitureThermique);
            vue.afficherMessage("Voiture thermique ajoutée avec succès !");
        } catch (SQLException e) {
            vue.afficherErreur("Erreur lors de l'ajout de la voiture thermique : " + e.getMessage());
        }
    }

    public void afficherVoitureThermique(int id) {
        try {
            VoitureThermique voiture = voitureThermiqueDAO.obtenirVoitureThermiqueParId(id);
            if (voiture != null) {
                vue.afficherDetailsVoiture(voiture.getMarque(), voiture.getModele(), voiture.getAnnee(), (int) voiture.getConsommationCarburant(), voiture.getPrixParJour());
            } else {
                vue.afficherErreur("Voiture thermique non trouvée.");
            }
        } catch (SQLException e) {
            vue.afficherErreur("Erreur lors de la récupération de la voiture thermique : " + e.getMessage());
        }
    }
}
