package com.rmoss.gestcar.dao;

import com.rmoss.gestcar.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un client
    public void ajouterClient(Client client) throws SQLException {
        String query = "INSERT INTO clients (nom, adresse, telephone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getTelephone());
            stmt.executeUpdate();
            client.setId(stmt.getGeneratedKeys().getInt(1));
        }
    }

    // Obtenir tous les clients
    public List<Client> obtenirTousLesClients() throws SQLException {
        String query = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                Client client = new Client(id, nom, adresse, telephone);
                clients.add(client);
            }
        }
        return clients;
    }

    // Récupérer un client par ID
    public Client obtenirClientParId(int id) throws SQLException {
        String query = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                return new Client(id,nom, adresse, telephone);
            }
        }
        return null;
    }

    // Mettre à jour un client
    public void mettreAJourClient(Client client) throws SQLException {
        String query = "UPDATE clients SET nom = ?, adresse = ?, telephone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getTelephone());
            stmt.setInt(4, client.getId());
           var nbRowsUpdated=  stmt.executeUpdate();
           System.out.println(nbRowsUpdated);
        }
    }

    // Supprimer un client
    public void supprimerClient(int id) throws SQLException {
        String query = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
