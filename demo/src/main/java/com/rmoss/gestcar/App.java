package com.rmoss.gestcar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application de Gestion de Véhicules" );
       // Création d'une instance de gestion des voitures
       GestionVoitures gestionVoitures = new GestionVoitures();

       // Ajout de deux voitures
       Voiture voiture1 = new Voiture("Toyota", "Corolla", 2020, 50.0);
       Voiture voiture2 = new Voiture("Honda", "Civic", 2019, 45.0);

       gestionVoitures.ajouterVoiture(voiture1);
       gestionVoitures.ajouterVoiture(voiture2);

       // Afficher toutes les voitures
       System.out.println("Liste des voitures disponibles :");
       gestionVoitures.afficherVoitures();

       // Rechercher une voiture par marque
       Voiture voitureRecherchee = gestionVoitures.rechercherVoitureParMarque("Toyota");
       if (voitureRecherchee != null) {
           System.out.println("\nVoiture trouvée :");
           voitureRecherchee.afficherInfo();
       } else {
           System.out.println("\nAucune voiture trouvée pour la marque spécifiée.");
       }
    }
}
