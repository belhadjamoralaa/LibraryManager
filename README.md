Projet Gestion de Librairie
Description
Application de gestion de librairie permettant de gérer des livres, des clients et des promotions.
Principes de Programmation Orientée Objet Utilisés
1. Encapsulation

Définition: Principe qui consiste à regrouper des données et les méthodes qui les manipulent dans une classe et à restreindre l'accès direct aux attributs.
Application dans le projet:

Les attributs des classes sont privés (private)
Accessibles uniquement via des getters/setters
Exemple dans la classe Livre: les attributs titre, prix, stock sont privés



2. Héritage

Définition: Mécanisme permettant de créer une nouvelle classe à partir d'une classe existante.
Application dans le projet:

Les classes PromoEte et PromoNoel héritent de l'interface PromoStrategy



3. Polymorphisme

Définition: Capacité d'un objet à prendre plusieurs formes.
Application dans le projet:

Différentes implémentations de PromoStrategy
Possibilité d'utiliser n'importe quelle promotion qui implémente PromoStrategy



4. Abstraction

Définition: Simplification d'un objet complexe en ne montrant que les détails essentiels.
Application dans le projet:

Interface PromoStrategy qui définit un contrat sans les détails d'implémentation
Méthodes publiques qui cachent la complexité interne



Design Patterns Utilisés
1. Singleton (Créationnel)

Définition: Garantit qu'une classe n'a qu'une seule instance et fournit un point d'accès global à celle-ci.
Où: Classe LibrairieManager
Pourquoi:

Une seule instance de la librairie est nécessaire
Accès global à la gestion de la librairie


Comment:
 static LibrairieManager instance;
public static LibrairieManager getInstance() {
    if (instance == null) {
        instance = new LibrairieManager();
    }
    return instance;
}
2. Strategy (Comportemental)

Définition: Définit une famille d'algorithmes et les rend interchangeables.
Où: Interface PromoStrategy et ses implémentations
Pourquoi:

Permet de changer facilement entre différentes stratégies de promotion
Facilite l'ajout de nouvelles promotions


Comment:

 interface PromoStrategy {
    double calculerPromo(double prix);
}

public class PromoEte implements PromoStrategy {
    public double calculerPromo(double prix) {
        return prix * 0.8;
    }
}
3. Observer (Comportemental)

Définition: Définit une dépendance de type un-à-plusieurs entre objets.
Où: Système de notification des clients
Pourquoi:

Informer automatiquement les clients des nouveaux livres
Découplage entre la librairie et les clients


Comment:
public void notifierClients(String message) {
    for (int i = 0; i < nombreClients; i++) {
        clients[i].notifier(message);
    }
}
Bonnes Pratiques Implémentées

Nommage explicite des classes et méthodes
Commentaires pour expliquer le code complexe
Gestion d'erreurs avec des messages clairs
Code modulaire et facilement extensible
Séparation des responsabilités entre les classes

Structure du Projet
Copysrc/
├── Livre.java
├── Client.java
├── PromoStrategy.java
├── PromoEte.java
├── PromoNoel.java
├── LibrairieManager.java
└── Main.java
