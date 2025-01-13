package library;

public class Client {
    private String nom;

    public Client(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }

    public void notifier(String message) {
        System.out.println("Message pour " + nom + ": " + message);
    }
}