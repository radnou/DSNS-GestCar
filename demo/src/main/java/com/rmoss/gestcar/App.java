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
        Voiture voiture1 = new Voiture("Mercedes", "Class E", 2022, 120.0);
        voiture1.afficherInfo();

        Voiture voiture2 = new Voiture("Toyota", "Corolla", 2020, 50.0);
        voiture2.afficherInfo();
    }
}
