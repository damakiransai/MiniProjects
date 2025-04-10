import java.util.*;

class Book {
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added.");
    }

    void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    void displayBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        do {
            System.out.println("\n1. Add Book\n2. Issue Book\n3. Return Book\n4. Display Books\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter title to issue: ");
                    title = sc.nextLine();
                    lib.issueBook(title);
                    break;
                case 3:
                    System.out.print("Enter title to return: ");
                    title = sc.nextLine();
                    lib.returnBook(title);
                    break;
                case 4:
                    lib.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
