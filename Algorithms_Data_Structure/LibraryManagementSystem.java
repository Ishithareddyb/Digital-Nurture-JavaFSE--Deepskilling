import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author);
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C Programming", "Dennis Ritchie"),
                new Book(104, "Data Structures", "Mark Allen"),
                new Book(105, "Operating Systems", "Galvin")
        };

        String searchTitle = "Python";

        System.out.println("Linear Search:");
        Book found1 = linearSearch(books, searchTitle);

        if (found1 != null) {
            found1.display();
        } else {
            System.out.println("Book Not Found");
        }

        Arrays.sort(books, Comparator.comparing(book -> book.title));

        System.out.println("\nBinary Search:");
        Book found2 = binarySearch(books, searchTitle);

        if (found2 != null) {
            found2.display();
        } else {
            System.out.println("Book Not Found");
        }
    }
}