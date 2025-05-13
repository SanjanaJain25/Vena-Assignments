package collection_Day3;
import java.util.*;

// Book class
class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
    }

    // Override equals() to avoid duplicates
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author) && publicationYear == other.publicationYear;
    }

    // Override hashCode() to support Set
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}

public class Q6_LibraryCatalog {

    //genre to set of books
    Map<String, Set<Book>> catalog = new HashMap<>();

    // Add book to genre
    void addBook(String genre, Book book) {
        catalog.putIfAbsent(genre, new HashSet<>());
        catalog.get(genre).add(book); // Set will ignore duplicates automatically
    }


    void printBooksByGenre(String genre) {
        Set<Book> books = catalog.get(genre);
        if (books == null) {
            System.out.println("No books found for genre: " + genre);
            return;
        }

        // Convert to list for sorting
        List<Book> bookList = new ArrayList<>(books);
        bookList.sort(Comparator.comparingInt(b -> b.publicationYear));

        System.out.println("\n📚 Books in Genre: " + genre);
        for (Book b : bookList) {
            System.out.println("  - " + b);
        }
    }

    public static void main(String[] args) {
        Q6_LibraryCatalog lib = new Q6_LibraryCatalog();

        // Adding books
        lib.addBook("Fiction", new Book("1984", "George Orwell", 1949));
        lib.addBook("Fiction", new Book("Brave New World", "Aldous Huxley", 1932));
        lib.addBook("Science", new Book("A Brief History of Time", "Stephen Hawking", 1988));
        lib.addBook("Fiction", new Book("1984", "George Orwell", 1949)); // Duplicate

        lib.addBook("Science", new Book("The Selfish Gene", "Richard Dawkins", 1976));

        // Display books
        lib.printBooksByGenre("Fiction");
        lib.printBooksByGenre("Science");
    }
}
