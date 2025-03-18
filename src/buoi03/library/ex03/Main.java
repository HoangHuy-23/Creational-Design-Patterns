package buoi03.library.ex03;

import java.util.ArrayList;
import java.util.List;


//Lớp trừu tượng Book đại diện cho sách trong thư viện
abstract class Book {
 protected String title;
 protected String author;
 protected String type;

 public Book(String title, String author, String type) {
     this.title = title;
     this.author = author;
     this.type = type;
 }

 public String getTitle() {
     return title;
 }

 public String getAuthor() {
     return author;
 }

 public String getType() {
     return type;
 }

 @Override
 public String toString() {
     return type + " - " + title + " by " + author;
 }
}

//Các loại sách cụ thể: PaperBook, EBook, AudioBook
class PaperBook extends Book {
 public PaperBook(String title, String author) {
     super(title, author, "Paper Book");
 }
}

class EBook extends Book {
 public EBook(String title, String author) {
     super(title, author, "E-Book");
 }
}

class AudioBook extends Book {
 public AudioBook(String title, String author) {
     super(title, author, "Audio Book");
 }
}

// Step 1: Định nghĩa interface SearchStrategy
interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}

// Step 2: Triển khai các chiến lược tìm kiếm cụ thể
class SearchByTitle implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

class SearchByAuthor implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

class SearchByType implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getType().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

// Step 3: Cập nhật Library để hỗ trợ các chiến lược tìm kiếm
class Library {
    private static volatile Library instance;
    private List<Book> books;
    private SearchStrategy searchStrategy;

    private Library() {
        books = new ArrayList<>();
        this.searchStrategy = new SearchByTitle(); // Default strategy
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

    public void addBook(Book book) {
        books.add(book);
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public List<Book> searchBooks(String keyword) {
        return searchStrategy.search(books, keyword);
    }

    public void displayBooks(List<Book> foundBooks) {
        if (foundBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }
}

// Step 4: Kiểm thử chương trình
public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Thêm sách vào thư viện
        library.addBook(new PaperBook("Clean Code", "Robert C. Martin"));
        library.addBook(new EBook("Effective Java", "Joshua Bloch"));
        library.addBook(new AudioBook("Atomic Habits", "James Clear"));
        library.addBook(new PaperBook("The Pragmatic Programmer", "Andy Hunt"));
        library.addBook(new EBook("Java Concurrency in Practice", "Brian Goetz"));

        // Tìm kiếm theo tiêu đề
        System.out.println("🔍 Searching by Title: 'Java'");
        library.setSearchStrategy(new SearchByTitle());
        library.displayBooks(library.searchBooks("Java"));

        // Tìm kiếm theo tác giả
        System.out.println("\n🔍 Searching by Author: 'Robert'");
        library.setSearchStrategy(new SearchByAuthor());
        library.displayBooks(library.searchBooks("Robert"));

        // Tìm kiếm theo loại sách
        System.out.println("\n🔍 Searching by Type: 'E-Book'");
        library.setSearchStrategy(new SearchByType());
        library.displayBooks(library.searchBooks("E-Book"));
    }
}

