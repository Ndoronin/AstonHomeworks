package homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    private String name;
    private int readerNumber;
    private boolean isInBlacklist;
    private List<Book> lendedBooks;

    public Reader(String name, int readerNumber) {
        this.name = name;
        this.readerNumber = readerNumber;
        this.isInBlacklist = false;
        lendedBooks = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReaderNumber() {
        return readerNumber;
    }

    public void setReaderNumber(int readerNumber) {
        this.readerNumber = readerNumber;
    }

    public void lendBook(Book book) {
        lendedBooks.add(book);
    }

    public void returnBook(Book book) {
        lendedBooks.remove(book);
    }

    public List<Book> getLendedBooks() {
        return lendedBooks;
    }


    public boolean isInBlacklist() {
        return isInBlacklist;
    }

    public void setInBlacklist(boolean isInBlacklist) {
        this.isInBlacklist = isInBlacklist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return readerNumber == reader.readerNumber && Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, readerNumber);
    }

    @Override
    public String toString() {
        return "The reader: " + name + ", reader id: " + readerNumber + ", Blacklisted: " + isInBlacklist;
    }
}