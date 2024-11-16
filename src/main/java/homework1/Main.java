package homework1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Reader> readers = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            books.add(new Book("Book "+i,"Author "+i, 1900+i));
            library.addBook(books.get(i-1));
        }
        for (int i = 1; i <= 10; i++) {
            readers.add(new Reader("reader "+i,i));
            library.registerReader(readers.get(i-1));
        }
        library.displayLibraryInfo();
        library.lendBook(readers.get(0), books.get(0));
        library.returnBook(readers.get(0), books.get(0));


    }
}
