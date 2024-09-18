package com.rmoss.gestcar.view;

import com.rmoss.gestcar.model.Voiture;
import com.rmoss.gestcar.model.VoitureThermique;

import java.util.Arrays;
import java.util.stream.Collectors;

public class VoitureView {

    public void afficherDetailsVoiture(String marque, String modele, int annee, Integer spec, Double prix) {
        System.out.println("Voiture : " + marque + " " + modele + " - Année : " + annee + " - Spécification : " + spec + " - Prix par jour : " + prix);
    }
    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public void afficherErreur(String message) {
        System.err.println("Erreur : " + message);
    }
}
