package com.rmoss.gestcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoitureThermiqueDAO {
    private final Connection connection;

    public VoitureThermiqueDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter une voiture thermique à la base de données
    public void ajouterVoitureThermique(VoitureThermique voitureThermique) throws SQLException {
        String query = "INSERT INTO voituresThermique (marque, modele, annee, consommationCarburant, prixParJour) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, voitureThermique.getMarque());
            stmt.setString(2, voitureThermique.getModele());
            stmt.setInt(3, voitureThermique.getAnnee());
            stmt.setDouble(4, voitureThermique.getConsommationCarburant());
            stmt.setDouble(5, voitureThermique.getPrixParJour());
            stmt.executeUpdate();
        }
    }

    // Méthode pour récupérer une voiture thermique par ID
    public VoitureThermique obtenirVoitureThermiqueParId(int id) throws SQLException {
        String query = "SELECT * FROM voituresThermique WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String marque = rs.getString("marque");
                String modele = rs.getString("modele");
                int annee = rs.getInt("annee");
                double consommationCarburant = rs.getDouble("consommationCarburant");
                double prixParJour = rs.getDouble("prixParJour");
                return new VoitureThermique(marque, modele, annee, prixParJour, consommationCarburant);
            }
        }
        return null;
    }

    // Méthode pour mettre à jour une voiture thermique dans la base de données
    public void mettreAJourVoitureThermique(VoitureThermique voitureThermique) throws SQLException {
        String query = "UPDATE voituresThermique SET marque = ?, modele = ?, annee = ?, consommationCarburant = ?, prixParJour = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, voitureThermique.getMarque());
            stmt.setString(2, voitureThermique.getModele());
            stmt.setInt(3, voitureThermique.getAnnee());
            stmt.setDouble(4, voitureThermique.getConsommationCarburant());
            stmt.setDouble(5, voitureThermique.getPrixParJour());
            stmt.setInt(6, voitureThermique.getId()); // ID de la voiture thermique
            stmt.executeUpdate();
        }
    }

    // Méthode pour supprimer une voiture thermique par ID
    public void supprimerVoitureThermique(int id) throws SQLException {
        String query = "DELETE FROM voituresThermique WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
