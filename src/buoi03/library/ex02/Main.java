package buoi03.library.ex02;

import java.util.ArrayList;
import java.util.List;


// Step 1: Tạo interface chung cho sách
interface Book {
    String getTitle();
    String getAuthor();
    String getType();
}

// Step 2: Các loại sách cụ thể
class PaperBook implements Book {
    private String title;
    private String author;

    public PaperBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getType() {
        return "Paper Book";
    }

    @Override
    public String toString() {
        return getType() + " - " + title + " by " + author;
    }
}

class EBook implements Book {
    private String title;
    private String author;

    public EBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getType() {
        return "E-Book";
    }

    @Override
    public String toString() {
        return getType() + " - " + title + " by " + author;
    }
}

class AudioBook implements Book {
    private String title;
    private String author;

    public AudioBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getType() {
        return "Audio Book";
    }

    @Override
    public String toString() {
        return getType() + " - " + title + " by " + author;
    }
}

// Step 3: Tạo Factory Method để sinh các loại sách
class BookFactory {
    public static Book createBook(String type, String title, String author) {
        switch (type.toUpperCase()) {
            case "PAPER":
                return new PaperBook(title, author);
            case "EBOOK":
                return new EBook(title, author);
            case "AUDIO":
                return new AudioBook(title, author);
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }
}

// Step 4: Cập nhật Library để dùng Factory Method
class Library {
    private static volatile Library instance;
    private List<Book> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public void addBook(String type, String title, String author) {
        Book book = BookFactory.createBook(type, title, author);
        books.add(book);
        System.out.println("Added: " + book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            books.forEach(System.out::println);
        }
    }
}

// Step 5: Kiểm thử chương trình
public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Thêm các loại sách khác nhau
        library.addBook("PAPER", "Clean Code", "Robert C. Martin");
        library.addBook("EBOOK", "Effective Java", "Joshua Bloch");
        library.addBook("AUDIO", "Atomic Habits", "James Clear");

        // Hiển thị danh sách sách
        System.out.println("\nLibrary Books:");
        library.displayBooks();
    }
}
