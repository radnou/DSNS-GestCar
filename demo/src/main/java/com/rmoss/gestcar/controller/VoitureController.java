package com.rmoss.gestcar.controller;

import com.rmoss.gestcar.model.Voiture;
import com.rmoss.gestcar.view.VoitureView;

public class VoitureController {
    private final Voiture modele;
    private final VoitureView vue;

    public VoitureController(Voiture modele, VoitureView vue) {
        this.modele = modele;
        this.vue = vue;
    }

    // Mise à jour de la vue avec les informations de la voiture
    public void updateView() {
        vue.afficherDetailsVoiture(modele.getMarque(), modele.getModele(), modele.getAnnee(),1, modele.getPrixParJour());
    }
}
