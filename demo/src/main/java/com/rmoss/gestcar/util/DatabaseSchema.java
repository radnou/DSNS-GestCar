package com.rmoss.gestcar.util;

import java.sql.Statement;

public class DatabaseSchema {
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
                "id INTEGER PRIMARY
