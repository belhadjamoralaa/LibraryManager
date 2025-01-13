package library;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LibrairieManager librairie = LibrairieManager.getInstance();

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer

            switch (choix) {
                case 1:
                    ajouterLivre();
                    break;
                case 2:
                    librairie.afficherLivres();
                    break;
                case 3:
                    ajouterClient();
                    break;
                case 4:
                    changerPromotion();
                    break;
                case 0:
                    continuer = false;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ajouter livre");
        System.out.println("2. Voir livres");
        System.out.println("3. Ajouter client");
        System.out.println("4. Changer promo");
        System.out.println("0. Quitter");
        System.out.print("Choix: ");
    }

    private static void ajouterLivre() {
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Prix: ");
        double prix = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Livre livre = new Livre(titre, prix, stock);
        if (librairie.ajouterLivre(livre)) {
            System.out.println("Livre ajouté!");
        } else {
            System.out.println("Plus de place!");
        }
    }

    private static void ajouterClient() {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        Client client = new Client(nom);
        if (librairie.ajouterClient(client)) {
            System.out.println("Client ajouté!");
        } else {
            System.out.println("Plus de place!");
        }
    }

    private static void changerPromotion() {
        System.out.println("1. Promo été (20%)");
        System.out.println("2. Promo Noël (30%)");
        int choix = scanner.nextInt();

        if (choix == 1) {
            librairie.setPromoStrategy(new PromoEte());
            System.out.println("Promo été active");
        } else if (choix == 2) {
            librairie.setPromoStrategy(new PromoNoel());
            System.out.println("Promo Noël active");
        }
    }
}