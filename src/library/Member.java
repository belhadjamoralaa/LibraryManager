package library;

class Member {
    private String name;
    private Book[] borrowedBooks;
    private int borrowedCount;
    private DiscountStrategy discountStrategy;
    
    Member(String name) {
        this.name = name;
        this.borrowedBooks = new Book[5];
        this.borrowedCount = 0;
    }
    
    void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }
    
    void borrowBook(Book book) {
        if(borrowedCount < borrowedBooks.length && book != null) {
            double finalPrice = discountStrategy != null ? 
                              discountStrategy.calculateDiscount(book.getPrice()) : 
                              book.getPrice();
            
            borrowedBooks[borrowedCount] = book;
            borrowedCount++;
            book.borrow();
            System.out.println("Livre emprunté! Prix final: " + finalPrice + "€");
        }
    }
    
    public String toString() {
        return "Nom: " + name + ", Livres empruntés: " + borrowedCount;
    }
}