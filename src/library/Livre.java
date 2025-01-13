package library;

public class Livre {
    private String titre;
    private double prix;
    private int stock;

    public Livre(String titre, double prix, int stock) {
        this.titre = titre;
        this.prix = prix;
        this.stock = stock;
    }

    public String getTitre() { return titre; }
    public double getPrix() { return prix; }
    public int getStock() { return stock; }

    public String toString() {
        return "Livre: " + titre + " - Prix: " + prix + "€ - Stock: " + stock;
    }
}

