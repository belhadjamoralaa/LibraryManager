package library;

class Library {
    private static Library instance;
    private Book[] books;
    private Member[] members;
    private int bookCount;
    private int memberCount;
    
    private Library() {
        books = new Book[100];
        members = new Member[50];
        bookCount = 0;
        memberCount = 0;
    }
    
    static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }
    
    void addBook(Book book) {
        if(bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Livre ajouté!");
        }
    }
    
    void addMember(Member member) {
        if(memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
            System.out.println("Membre ajouté!");
        }
    }
    
    void displayBooks() {
        if(bookCount == 0) {
            System.out.println("Aucun livre disponible");
            return;
        }
        for(int i = 0; i < bookCount; i++) {
            System.out.println(i + ") " + books[i]);
        }
    }
    
    void displayMembers() {
        if(memberCount == 0) {
            System.out.println("Aucun membre inscrit");
            return;
        }
        for(int i = 0; i < memberCount; i++) {
            System.out.println(i + ") " + members[i]);
        }
    }
    
    Book getBook(int index) {
        if(index >= 0 && index < bookCount) {
            return books[index];
        }
        return null;
    }
    
    Member getMember(int index) {
        if(index >= 0 && index < memberCount) {
            return members[index];
        }
        return null;
    }
}
