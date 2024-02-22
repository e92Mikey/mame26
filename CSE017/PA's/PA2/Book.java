public class Book extends Title {
    private String author;
    private String isbn;

    public Book(String callNumber, String title, String publisher, int year, int copies, String author, String isbn) {
        super(callNumber, title, publisher, year, copies);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toFileString() {
        return String.format("%s|%s|%s|%d|%d|%s|%s", getCallNumber(), getTitle(), getPublisher(), getYear(), getCopies(), getAuthor(), getIsbn());
    }

}
