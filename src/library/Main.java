package library;
class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Menu menu = new Menu();
        menu.showMenu();
    }
}