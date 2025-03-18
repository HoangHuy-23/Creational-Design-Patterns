package buoi03.library.ex01;

import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

// Singleton Library class
class Library {
    private static volatile Library instance;  // Ensure thread safety
    private List<Book> books;

    private Library() {  // Private constructor to prevent instantiation
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {  // Double-checked locking
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            books.forEach(System.out::println);
        }
    }
}

// Main class to test the singleton
public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Adding books
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Design Patterns", "Erich Gamma"));

        // Display books
        System.out.println("Library Books:");
        library.displayBooks();

        // Removing a book
        library.removeBook("Clean Code");
        System.out.println("\nAfter removing 'Clean Code':");
        library.displayBooks();
    }
}
