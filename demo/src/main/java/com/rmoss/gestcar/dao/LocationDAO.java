package com.rmoss.gestcar.dao;

import com.rmoss.gestcar.model.Client;
import com.rmoss.gestcar.model.Location;
import com.rmoss.gestcar.model.Voiture;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocationDAO {
    private final Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter une location
    public void ajouterLocation(Location location) throws SQLException {
        String query = "INSERT INTO locations (clientId, voitureId, dateDebut, dateFin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, location.getClient().getId());
            stmt.setInt(2, location.getVoiture().getId());
            stmt.setDate(3, Date.valueOf(location.getDateDebut()));
            stmt.setDate(4, Date.valueOf(location.getDateFin()));
            stmt.executeUpdate();
        }
    }

    // Récupérer une location par ID
    public Location obtenirLocationParId(int id) throws SQLException {
        String query = "SELECT * FROM locations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Récupérer les informations de la location, Client et Voiture sont récupérés via leurs DAO respectifs
                Client client = new ClientDAO(connection).obtenirClientParId(rs.getInt("clientId"));
                Voiture voiture = new VoitureThermiqueDAO(connection).obtenirVoitureThermiqueParId(rs.getInt("voitureId")); // Adapte pour électrique si nécessaire
                String dateDebut = rs.getString("dateDebut");
                String dateFin = rs.getString("dateFin");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                var dateDebutFormat = LocalDate.parse(dateDebut, formatter);
                var dateFinFormat = LocalDate.parse(dateFin, formatter);
                return new Location(voiture, client, dateDebutFormat, dateFinFormat);
            }
        }
        return null;
    }

    // Supprimer une location
    public void supprimerLocation(int id) throws SQLException {
        String query = "DELETE FROM locations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
