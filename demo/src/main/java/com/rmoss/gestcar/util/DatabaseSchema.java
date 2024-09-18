package com.rmoss.gestcar.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DatabaseSchema {

    public static void reset (Connection connection) throws SQLException {
          try (Statement stmt = connection.createStatement()) {

              //Drop Tables
              var requeteDropTablelocations = "DROP TABLE IF exists locations";

              var requeteDropTableclients = "DROP TABLE IF exists clients";

             // var requeteDropTablesqlite_master = "DROP TABLE if exists sqlite_master";

              //var requeteDropTablesqlite_sequence = "DROP TABLE if exists sqlite_sequence";

              var requeteDropTablevoituresElectrique = "DROP TABLE if exists voituresElectrique";

              var requeteDropTablevoituresThermique = "DROP TABLE if exists voituresThermique";

              // Reset des tables
              stmt.addBatch(requeteDropTablelocations);
              //stmt.addBatch(requeteDropTablesqlite_master);
              //stmt.addBatch(requeteDropTablesqlite_sequence);
              stmt.addBatch(requeteDropTablevoituresElectrique);
              stmt.addBatch(requeteDropTablevoituresThermique);
              stmt.addBatch(requeteDropTableclients);

              var resultatBatchExecution = stmt.executeBatch();
              System.out.println(Arrays.toString(resultatBatchExecution));
          } catch (SQLException e) {
              System.err.println(e.getMessage());
              throw new SQLException(e);
          }
    }

    public static void init(Connection connection) {
        try (Statement stmt = connection.createStatement()) {

            // Création de la table VoituresThermique
            String createVoituresThermiqueTable = "CREATE TABLE IF NOT EXISTS voituresThermique (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "marque TEXT NOT NULL," +
                    "modele TEXT NOT NULL," +
                    "annee INTEGER NOT NULL," +
                    "consommationCarburant REAL NOT NULL," +
                    "prixParJour REAL NOT NULL" +
                    ")";
            stmt.execute(createVoituresThermiqueTable);

            // Création de la table VoituresElectrique
            String createVoituresElectriqueTable = "CREATE TABLE IF NOT EXISTS voituresElectrique (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "marque TEXT NOT NULL," +
                    "modele TEXT NOT NULL," +
                    "annee INTEGER NOT NULL," +
                    "autonomieBatterie TEXT NOT NULL," +
                    "prixParJour REAL NOT NULL" +
                    ")";
            stmt.execute(createVoituresElectriqueTable);

            // Création de la table Clients
            String createClientsTable = "CREATE TABLE IF NOT EXISTS clients (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom TEXT NOT NULL," +
                    "adresse TEXT NOT NULL," +
                    "telephone TEXT NOT NULL" +
                    ")";
            stmt.execute(createClientsTable);

            // Création de la table Locations
            String createLocationsTable = "CREATE TABLE IF NOT EXISTS locations (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "clientId INTEGER NOT NULL," +
                    "voitureId INTEGER NOT NULL," +
                    "dateDebut TEXT NOT NULL," +
                    "dateFin TEXT NOT NULL," +
                    "FOREIGN KEY(clientId) REFERENCES clients(id)," +
                    "FOREIGN KEY(voitureId) REFERENCES voituresThermique(id)" +  // Adapte pour électrique aussi
                    ")";
            stmt.execute(createLocationsTable);

            System.out.println("Tables créées avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création des tables : " + e.getMessage());
        }
    }
}
