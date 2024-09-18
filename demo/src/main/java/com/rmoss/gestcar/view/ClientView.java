package com.rmoss.gestcar.view;

import com.rmoss.gestcar.model.Client;

import java.util.List;

public class ClientView {

    // Afficher un message dans la console
    public void afficherMessage(String message) {
        System.out.println(message);
    }

    // Afficher une erreur dans la console
    public void afficherErreur(String message) {
        System.err.println("Erreur : " + message);
    }

    // Afficher une liste de clients sous forme de tableau
    public void afficherClients(List<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé.");
            return;
        }

        // Affichage de l'entête du tableau
        System.out.printf("%-5s %-20s %-30s %-15s%n", "ID", "Nom", "Adresse", "Téléphone");
        System.out.println("-----------------------------------------------------------------------");

        // Affichage des clients
        for (Client client : clients) {
            System.out.printf("%-5d %-20s %-30s %-15s%n",
                    client.getId(), client.getNom(), client.getAdresse(), client.getTelephone());
        }

        System.out.println("-----------------------------------------------------------------------");
    }
}
