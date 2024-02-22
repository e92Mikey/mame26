public class Periodical extends Title {
    private int issue;
    private String month;

    // Constructor for Periodical
    public Periodical(String callNumber, String title, String publisher, int year, int copies, String month, int issue) {
        super(callNumber, title, publisher, year, copies);
        this.month = month;
        this.issue = issue;
    }

    // Getter methods for month and issue
    public String getMonth() {
        return month;
    }

    public int getIssue() {
        return issue;
    }

    // Implemented method to convert periodical to file string
    @Override
    public String toFileString() {
        return String.format("%s|%s|%s|%d|%d|%s|%d", getCallNumber(), getTitle(), getPublisher(), getYear(), getCopies(), getMonth(), getIssue());
    }
}
