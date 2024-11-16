package homework1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private Administrator admin;
    private List<Reader> readers;
    private List<Book> books;
    private List<String> blackList;

    public Library() {
        this.readers = new ArrayList<>();
        this.books = new ArrayList<>();
        this.blackList = new ArrayList<>();
    }

    public Library(Administrator admin) {
        this.admin = admin;
    }


    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public boolean isReaderRegistered(int readerNumber) {
        return readers.stream().anyMatch(r -> r.getReaderNumber() == readerNumber);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean lendBook(Reader reader, Book book) {
        if (!isReaderRegistered(reader.getReaderNumber())) {
            System.out.println("The reader is not registered.");
            return false;
        }
        Optional<Book> optionalBook = books.stream()
                .filter(someBook -> someBook.getTitle().equals(book.getTitle()))
                .filter(Book::isAvailable)
                .findFirst();
        Optional<Reader> optionalReader = readers.stream()
                .filter(someReader -> someReader.equals(reader))
                .findFirst();

        if (optionalBook.isEmpty() || optionalReader.isEmpty()) {
            System.out.println("The book is not available or does not exist or reader is not registered.");
            return false;
        } else {
            Book existingBook = optionalBook.get();
            Reader existingReader = optionalReader.get();
            existingBook.setStatus(BookStatus.BORROWED);
            existingBook.setLender(reader);
            existingReader.lendBook(existingBook);

            System.out.println("The book " + book.getTitle() + " has been borrowed by " + reader.getName());
            return true;
        }
    }

    public void returnBook(Reader reader, Book book) {


        Optional<Book> optionalBook = books.stream()
                .filter(someBook -> someBook.getTitle().equals(book.getTitle()))
                .findFirst();
        Optional<Reader> optionalReader = readers.stream()
                .filter(someReader -> someReader.equals(reader))
                .findFirst();
        if (optionalBook.isEmpty() || optionalReader.isEmpty()) {
            System.out.println("The book does not exist or reader is not registered.");
        }else{
            Book existingBook = optionalBook.get();
            Reader existingReader = optionalReader.get();
            existingBook.setStatus(BookStatus.AVAILABLE);
            existingReader.returnBook(existingBook);
            System.out.println("Book is returned.");
        }
    }

    public void checkDueDate(Book book) {
        LocalDate dueDate = LocalDate.now().plusDays(14);
        if (LocalDate.now().isAfter(dueDate)) {
            book.setStatus(BookStatus.OVERDUE);
            admin.blacklistReader(book.getLender());
            System.out.println("Book " + book.getTitle() + " is overdue. Reader has been added to the blacklist.");
        } else {
            System.out.println("Return period has not expired for the book" + book.getTitle());
        }
    }

    public void displayBlacklist() {
        System.out.println("The blacklist:");
        for (Reader reader : admin.blacklistedReaders) {
            System.out.println(reader);
        }
    }



    public void displayLibraryInfo() {
        System.out.println("Library Information:");
        System.out.println("Number of readers: " + readers.size());
        System.out.println("Books: " + books.size());
        System.out.println("Blacklisted readers: " + blackList.size());
    }
}
