package library;

class Menu {
    private Library library;
    
    Menu() {
        library = Library.getInstance();
    }
    
    void showMenu() {
        while(true) {
            System.out.println("\n=== MENU BIBLIOTHÈQUE ===");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Ajouter un membre");
            System.out.println("3. Afficher les livres");
            System.out.println("4. Afficher les membres");
            System.out.println("5. Emprunter un livre");
            System.out.println("6. Quitter");
            System.out.print("Choix: ");
            
            int choice = Integer.parseInt(System.console().readLine());
            
            switch(choice) {
                case 1: addBook(); break;
                case 2: addMember(); break;
                case 3: library.displayBooks(); break;
                case 4: library.displayMembers(); break;
                case 5: borrowBook(); break;
                case 6: return;
                default: System.out.println("Option invalide!");
            }
        }
    }
    
    private void addBook() {
        System.out.print("Titre: ");
        String title = System.console().readLine();
        System.out.print("Auteur: ");
        String author = System.console().readLine();
        System.out.print("Prix: ");
        double price = Double.parseDouble(System.console().readLine());
        
        library.addBook(new Book(title, author, price));
    }
    
    private void addMember() {
        System.out.print("Nom: ");
        String name = System.console().readLine();
        Member member = new Member(name);
        
        System.out.println("Type de réduction (1: Direct, 2: Code, 3: Aucune): ");
        int discountType = Integer.parseInt(System.console().readLine());
        
        switch(discountType) {
            case 1:
                System.out.print("Pourcentage (0-1): ");
                double percentage = Double.parseDouble(System.console().readLine());
                member.setDiscountStrategy(new DirectDiscount(percentage));
                break;
            case 2:
                System.out.print("Code: ");
                String code = System.console().readLine();
                member.setDiscountStrategy(new CodeDiscount(code));
                break;
        }
        
        library.addMember(member);
    }
    
    private void borrowBook() {
        System.out.println("\nListe des livres:");
        library.displayBooks();
        System.out.print("Numéro du livre: ");
        int bookIndex = Integer.parseInt(System.console().readLine());
        
        System.out.println("\nListe des membres:");
        library.displayMembers();
        System.out.print("Numéro du membre: ");
        int memberIndex = Integer.parseInt(System.console().readLine());
        
        Member member = library.getMember(memberIndex);
        Book book = library.getBook(bookIndex);
        
        if(member != null && book != null) {
            member.borrowBook(book);
        } else {
            System.out.println("Erreur: membre ou livre invalide!");
        }
    }
}