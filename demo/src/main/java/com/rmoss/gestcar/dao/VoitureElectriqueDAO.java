package com.rmoss.gestcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoitureElectriqueDAO {
    private final Connection connection;

    public VoitureElectriqueDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter une voiture électrique à la base de données
    public void ajouterVoitureElectrique(VoitureElectrique voitureElectrique) throws SQLException {
        String query = "INSERT INTO voituresElectrique (marque, modele, annee, autonomieBatterie, prixParJour) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, voitureElectrique.getMarque());
            stmt.setString(2, voitureElectrique.getModele());
            stmt.setInt(3, voitureElectrique.getAnnee());
            stmt.setString(4, voitureElectrique.getAutonomieBatterie());
            stmt.setDouble(5, voitureElectrique.getPrixParJour());
            stmt.executeUpdate();
        }
    }

    // Méthode pour récupérer une voiture électrique par ID
    public VoitureElectrique obtenirVoitureElectriqueParId(int id) throws SQLException {
        String query = "SELECT * FROM voituresElectrique WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String marque = rs.getString("marque");
                String modele = rs.getString("modele");
                int annee = rs.getInt("annee");
                String autonomieBatterie = rs.getString("autonomieBatterie");
                double prixParJour = rs.getDouble("prixParJour");
                return new VoitureElectrique(marque, modele, annee, prixParJour, autonomieBatterie);
            }
        }
        return null;
    }

    // Méthode pour mettre à jour une voiture électrique dans la base de données
    public void mettreAJourVoitureElectrique(VoitureElectrique voitureElectrique) throws SQLException {
        String query = "UPDATE voituresElectrique SET marque = ?, modele = ?, annee = ?, autonomieBatterie = ?, prixParJour = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, voitureElectrique.getMarque());
            stmt.setString(2, voitureElectrique.getModele());
            stmt.setInt(3, voitureElectrique.getAnnee());
            stmt.setString(4, voitureElectrique.getAutonomieBatterie());
            stmt.setDouble(5, voitureElectrique.getPrixParJour());
            stmt.setInt(6, voitureElectrique.getId()); // ID de la voiture électrique
            stmt.executeUpdate();
        }
    }

    // Méthode pour supprimer une voiture électrique par ID
    public void supprimerVoitureElectrique(int id) throws SQLException {
        String query = "DELETE FROM voituresElectrique WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
