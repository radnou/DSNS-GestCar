package com.rmoss.gestcar;

import com.rmoss.gestcar.controller.ClientController;
import com.rmoss.gestcar.controller.VoitureElectriqueController;
import com.rmoss.gestcar.controller.VoitureThermiqueController;
import com.rmoss.gestcar.dao.ClientDAO;
import com.rmoss.gestcar.dao.VoitureElectriqueDAO;
import com.rmoss.gestcar.dao.VoitureThermiqueDAO;
import com.rmoss.gestcar.model.Client;
import com.rmoss.gestcar.model.VoitureElectrique;
import com.rmoss.gestcar.model.VoitureThermique;
import com.rmoss.gestcar.util.DatabaseConnection;
import com.rmoss.gestcar.util.DatabaseSchema;
import com.rmoss.gestcar.view.ClientView;
import com.rmoss.gestcar.view.VoitureView;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
        // Connexion à la base de données
        Connection connection = DatabaseConnection.connect();
        DatabaseSchema.reset(connection);
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

      // Initialisation du DAO, Vue, et Contrôleur
        ClientDAO clientDAO = new ClientDAO(connection);
        ClientView clientView = new ClientView();
        ClientController clientController = new ClientController(clientDAO, clientView);

        // Ajouter un client
        Client client1 = new Client(0,"Jean Dupont", "123 Rue de Paris", "0123456789");
        clientController.ajouterClient(client1);

        // Ajouter un autre client
        Client client2 = new Client(0,"Marie Curie", "456 Rue des Sciences", "0987654321");
        clientController.ajouterClient(client2);

        // Afficher tous les clients sous forme de tableau
        clientController.afficherTousLesClients();

        // Modifier un client
        client1.setNom("Jean Dupont Modifié");
        client1.setAdresse("789 Avenue de la République");
        clientController.modifierClient(client1);

        // Supprimer un client
        System.out.println("Suppression Client 2");
        clientController.supprimerClient(client2.getId());

        // Afficher les clients après modification et suppression
        clientController.afficherTousLesClients();

        // Fermer la connexion à la base de données
        DatabaseConnection.close();


    }
}
