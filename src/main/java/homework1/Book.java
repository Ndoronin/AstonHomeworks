package homework1;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private BookStatus status ;
    private Reader lender;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setLender(Reader lender) {
        this.lender = lender;
    }

    public Reader getLender() {
        return this.lender;
    }

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Publication year: " + publicationYear;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

}