package com.rmoss.gestcar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:voitures.db";  // URL de la base de données SQLite
    private static Connection connection = null;

    // Méthode pour établir la connexion
    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                // Charger le driver JDBC pour SQLite
                Class.forName("org.sqlite.JDBC");
                // Établir la connexion à la base de données
                connection = DriverManager.getConnection(URL);
                System.out.println("Connexion à la base de données SQLite établie.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
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
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
