package com.rmoss.gestcar;

import com.rmoss.gestcar.controller.VoitureElectriqueController;
import com.rmoss.gestcar.controller.VoitureThermiqueController;
import com.rmoss.gestcar.dao.VoitureElectriqueDAO;
import com.rmoss.gestcar.dao.VoitureThermiqueDAO;
import com.rmoss.gestcar.model.VoitureElectrique;
import com.rmoss.gestcar.model.VoitureThermique;
import com.rmoss.gestcar.util.DatabaseConnection;
import com.rmoss.gestcar.util.DatabaseSchema;
import com.rmoss.gestcar.view.VoitureView;

import java.sql.Connection;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Connexion à la base de données
        Connection connection = DatabaseConnection.connect();
        DatabaseSchema.init(connection);

        // Initialiser les DAO et la Vue
        VoitureThermiqueDAO voitureThermiqueDAO = new VoitureThermiqueDAO(connection);
        VoitureElectriqueDAO voitureElectriqueDAO = new VoitureElectriqueDAO(connection);
        VoitureView vue = new VoitureView();

        // Créer les contrôleurs
        VoitureThermiqueController thermiqueController = new VoitureThermiqueController(voitureThermiqueDAO, vue);
        VoitureElectriqueController electriqueController = new VoitureElectriqueController(voitureElectriqueDAO, vue);

        // Ajouter une voiture thermique
        VoitureThermique voitureThermique = new VoitureThermique("Peugeot", "208", 2021, 15.0, 60.0);
        thermiqueController.ajouterVoitureThermique(voitureThermique);

        // Ajouter une voiture électrique
        VoitureElectrique voitureElectrique = new VoitureElectrique("Tesla", "Model S", 2022, 500.0, 120);
        electriqueController.ajouterVoitureElectrique(voitureElectrique);

        // Afficher les détails d'une voiture thermique
        thermiqueController.afficherVoitureThermique(1);

        // Afficher les détails d'une voiture électrique
        electriqueController.afficherVoitureElectrique(1);
    }
}
