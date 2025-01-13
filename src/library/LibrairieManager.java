package library;

public class LibrairieManager {
    private static LibrairieManager instance;
    private Livre[] livres;
    private Client[] clients;
    private PromoStrategy promoStrategy;
    private int nombreLivres;
    private int nombreClients;
    private static final int MAX_LIVRES = 10;
    private static final int MAX_CLIENTS = 5;

    private LibrairieManager() {
        livres = new Livre[MAX_LIVRES];
        clients = new Client[MAX_CLIENTS];
        nombreLivres = 0;
        nombreClients = 0;
    }

    public static LibrairieManager getInstance() {
        if (instance == null) {
            instance = new LibrairieManager();
        }
        return instance;
    }

    public void setPromoStrategy(PromoStrategy strategy) {
        this.promoStrategy = strategy;
    }

    public boolean ajouterLivre(Livre livre) {
        if (nombreLivres < MAX_LIVRES) {
            livres[nombreLivres] = livre;
            nombreLivres++;
            notifierClients("Nouveau livre: " + livre.getTitre());
            return true;
        }
        return false;
    }

    public boolean ajouterClient(Client client) {
        if (nombreClients < MAX_CLIENTS) {
            clients[nombreClients] = client;
            nombreClients++;
            return true;
        }
        return false;
    }

    public void notifierClients(String message) {
        for (int i = 0; i < nombreClients; i++) {
            clients[i].notifier(message);
        }
    }

    public double appliquerPromo(Livre livre) {
        if (promoStrategy == null) {
            return livre.getPrix();
        }
        return promoStrategy.calculerPromo(livre.getPrix());
    }

    public void afficherLivres() {
        if (nombreLivres == 0) {
            System.out.println("Aucun livre en stock");
            return;
        }
        System.out.println("\n=== LIVRES ===");
        for (int i = 0; i < nombreLivres; i++) {
            System.out.println(livres[i]);
            System.out.println("Prix promo: " + appliquerPromo(livres[i]) + "€");
            System.out.println("-----------");
        }
    }
}
