package buoi03.library.ex04;

import java.util.ArrayList;
import java.util.List;


interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

interface Observer {
    void update(String message);
}

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

//Singleton Library triển khai Subject để thông báo khi có sách mới hoặc sách trả về
class Library implements Subject {
 private static volatile Library instance;
 private List<Book> books;
 private List<Observer> observers;

 private Library() {
     books = new ArrayList<>();
     observers = new ArrayList<>();
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
     notifyObservers("📢 Sách mới đã có: " + book.getTitle() + " by " + book.getAuthor());
 }

 public void returnBook(Book book) {
     books.add(book);
     notifyObservers("✅ Sách đã được trả lại và có sẵn để mượn: " + book.getTitle());
 }

 @Override
 public void addObserver(Observer observer) {
     observers.add(observer);
 }

 @Override
 public void removeObserver(Observer observer) {
     observers.remove(observer);
 }

 @Override
 public void notifyObservers(String message) {
     for (Observer observer : observers) {
         observer.update(message);
     }
 }
}

//Nhân viên thư viện nhận thông báo khi có sách mới hoặc sách trả về
class Librarian implements Observer {
 private String name;

 public Librarian(String name) {
     this.name = name;
 }

 @Override
 public void update(String message) {
     System.out.println("📘 Nhân viên " + name + " nhận thông báo: " + message);
 }
}

//Người dùng đăng ký theo dõi sách
class LibraryUser implements Observer {
 private String name;

 public LibraryUser(String name) {
     this.name = name;
 }

 @Override
 public void update(String message) {
     System.out.println("📩 Người dùng " + name + " nhận thông báo: " + message);
 }
}



public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Tạo nhân viên thư viện và người dùng
        Librarian librarian1 = new Librarian("Huy");
        Librarian librarian2 = new Librarian("An");
        LibraryUser user1 = new LibraryUser("Ngọc");
        LibraryUser user2 = new LibraryUser("Kỳ");

        // Đăng ký nhận thông báo
        library.addObserver(librarian1);
        library.addObserver(librarian2);
        library.addObserver(user1);
        library.addObserver(user2);

        // Thêm sách mới
        Book book1 = new PaperBook("Clean Code", "Robert C. Martin");
        Book book2 = new EBook("Effective Java", "Joshua Bloch");

        System.out.println("\n📚 Thêm sách vào thư viện:");
        library.addBook(book1);
        library.addBook(book2);

        // Trả sách về thư viện
        System.out.println("\n🔄 Trả sách:");
        library.returnBook(book1);

        // Người dùng user2 không muốn nhận thông báo nữa
        System.out.println("\n🚫 Người dùng Kỳ hủy đăng ký nhận thông báo");
        library.removeObserver(user2);

        // Thêm sách mới sau khi user2 đã hủy nhận thông báo
        System.out.println("\n📚 Thêm sách mới:");
        library.addBook(new AudioBook("Atomic Habits", "James Clear"));
    }
}
