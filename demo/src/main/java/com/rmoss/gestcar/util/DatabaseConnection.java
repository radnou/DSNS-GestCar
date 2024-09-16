package com.rmoss.gestcar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:demo/src/main/java/com/rmoss/gestcar/data/voitures.db";  // Spécifiez ici l'URL de votre fichier SQLite
    private static Connection connection = null;

    // Méthode pour établir la connexion
    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.sqlite.JDBC");  // Charger le driver JDBC pour SQLite
                connection = DriverManager.getConnection(URL);  // Établir la connexion
                System.out.println("Connexion à la base de données SQLite établie.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
