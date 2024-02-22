import java.time.LocalDate;

public abstract class Title {
    private String callNumber;
    private String title;
    private String publisher;
    private int year;
    private int copies;

    public Title(String callNumber, String title, int year) {
        this.callNumber = callNumber;
        this.title = title;
        this.year = year;
    }

    public Title(String callNumber2, String title2, String publisher2, int year2, int copies2) {
    }

    public abstract String toFileString();

    public String getPublisher() {
        return publisher;
    }

    public int getCopies() {
        return copies;
    }
    
    public String getCallNumber() {
        return callNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

        public String simpleToString() {
        return String.format("%s   %s   %s   %d   %d", callNumber, title, publisher, year, copies);
    }

    public int compareTo(Title other) {
        return Integer.compare(this.year, other.year);
    }

    public Title clone() {
        try {
            return (Title) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isRestorable() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - year >= 50;
    }
}
