package PracticeSheet;

public class BookLibraryApp {

    // Book class
    static class Book {
        private String title;
        private String author;
        private String isdn;

        public Book(String title, String author, String isdn) {
            this.title = title;
            this.author = author;
            this.isdn = isdn;
        }

        public String getTitle() {
            return title;
        }

        public void printDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISDN: " + isdn);
        }
    }

    // Library class
    static class Library {
        private Book[] books;
        private int count;

        public Library(int capacity) {
            books = new Book[capacity];
            count = 0;
        }

        public void addBook(Book book) {
            if (count < books.length) {
                books[count++] = book;
            } else {
                System.out.println("Library is full. Cannot add more books.");
            }
        }

        public Book searchByTitle(String title) {
            for (int i = 0; i < count; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title)) {
                    return books[i];
                }
            }
            return null;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Library library = new Library(5); // Fixed capacity of 5 books

        // Adding books
        library.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
        library.addBook(new Book("Java Basics", "John Smith", "1234567890"));
        library.addBook(new Book("Python","albert","12345678990"));

        // Search and print
        Book found = library.searchByTitle("Java Basics");
        if (found != null) {
            System.out.println("\nBook found:");
            found.printDetails();
        } else {
            System.out.println("\nBook not found.");
        }


    }
}


