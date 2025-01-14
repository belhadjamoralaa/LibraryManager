package library;

class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;
    
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }
    
    void borrow() {
        isAvailable = false;
    }
    
    void returnBook() {
        isAvailable = true;
    }
    
    double getPrice() {
        return price;
    }
    
    public String toString() {
        return "Titre: " + title + ", Auteur: " + author + ", Prix: " + price + "€, Disponible: " + isAvailable;
    }
}
