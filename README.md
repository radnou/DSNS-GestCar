# Gestion de Location de Voitures

## Description
Ce projet consiste à développer une application de gestion de location de voitures en Java. 
Cette première version met en place la structure du projet et les configurations de base.

# Gestion de Location de Voitures - Branche 01-poo-basics
## Pre-requis 
- Git
- Java 21 
- Maven
- vscode ou eclipse 

## Objectif
Cette branche met en place les concepts fondamentaux de la **programmation orientée objet (POO)** avec un exemple de gestion de voitures thermiques et électriques. Les principales notions abordées sont :
- Encapsulation
- Héritage
- Polymorphisme
- Surcharge
- Redéfinition de méthodes (Override)

## Classes et structure
1. **Voiture (classe abstraite)** :
    - Représente la classe de base pour toutes les voitures.
    - Contient des attributs comme la marque, le modèle, l'année, et le prix par jour.
    - Définit des méthodes abstraites `afficherInfo()` et `calculerConsommation()` que les sous-classes doivent implémenter.

2. **VoitureThermique (hérite de Voiture)** :
    - Spécialisation pour les voitures thermiques avec un attribut supplémentaire : consommation de carburant (litres/100 km).
    - Implémente les méthodes abstraites de `Voiture` pour afficher des informations spécifiques et calculer la consommation.

3. **VoitureElectrique (hérite de Voiture)** :
    - Spécialisation pour les voitures électriques avec un attribut supplémentaire : autonomie de la batterie (en km).
    - Implémente les méthodes abstraites de `Voiture` pour afficher des informations spécifiques et calculer l'autonomie.

## Principes POO abordés

### 1. Encapsulation
Chaque classe encapsule ses attributs et utilise des **getters** et **setters** pour y accéder de manière contrôlée. Cela permet de protéger les données et de les rendre accessibles uniquement via des méthodes définies.

### 2. Héritage
Les classes `VoitureThermique` et `VoitureElectrique` héritent de la classe abstraite `Voiture`. Elles réutilisent les attributs et les méthodes de `Voiture` et ajoutent des fonctionnalités spécifiques à leur type de véhicule.

### 3. Polymorphisme
Grâce au polymorphisme, il est possible de manipuler des objets de différentes sous-classes (`VoitureThermique` et `VoitureElectrique`) comme des objets de type `Voiture`. Cela permet de traiter les deux types de voitures de manière générique tout en bénéficiant de leurs particularités.

Exemple d'utilisation :
```java
Voiture voitureThermique = new VoitureThermique("Renault", "Megane", 2018, 40.0, 6.5);
Voiture voitureElectrique = new VoitureElectrique("Tesla", "Model 3", 2022, 100.0, 450);

voitureThermique.afficherInfo();
voitureElectrique.afficherInfo();

```
## Execution 


```bash 
mvn compile
mvn exec:java -Dexec.mainClass="com.rmoss.getscar.App"
```