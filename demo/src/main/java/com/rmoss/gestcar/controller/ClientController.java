package com.rmoss.gestcar.controller;


import com.rmoss.gestcar.dao.ClientDAO;
import com.rmoss.gestcar.model.Client;
import com.rmoss.gestcar.view.ClientView;

import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private final ClientDAO clientDAO;
    private final ClientView clientView;

    public ClientController(ClientDAO clientDAO, ClientView clientView) {
        this.clientDAO = clientDAO;
        this.clientView = clientView;
    }

    // Ajouter un client
    public void ajouterClient(Client client) {
        try {
            clientDAO.ajouterClient(client);
            clientView.afficherMessage("Client ajouté avec succès !");
        } catch (SQLException e) {
            clientView.afficherErreur("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    // Modifier un client
    public void modifierClient(Client client) {
        try {
            clientDAO.mettreAJourClient(client);
            clientView.afficherMessage("Client modifié avec succès !");
        } catch (SQLException e) {
            clientView.afficherErreur("Erreur lors de la modification du client : " + e.getMessage());
        }
    }

    // Supprimer un client
    public void supprimerClient(int id) {
        try {
            clientDAO.supprimerClient(id);
            clientView.afficherMessage("Client supprimé avec succès !");
        } catch (SQLException e) {
            clientView.afficherErreur("Erreur lors de la suppression du client : " + e.getMessage());
        }
    }

    // Afficher tous les clients
    public void afficherTousLesClients() {
        try {
            List<Client> clients = clientDAO.obtenirTousLesClients();
            clientView.afficherClients(clients);
        } catch (SQLException e) {
            clientView.afficherErreur("Erreur lors de l'affichage des clients : " + e.getMessage());
        }
    }
}
