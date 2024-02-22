import java.io.*;
import java.util.*;

public class Catalog {
    private Title[] titles;
    private int count;

    public Catalog(int initialCapacity) {
        titles = new Title[initialCapacity];
        count = 0;
    }

    public void viewAllTitles() {
        System.out.println("Call Number     Title                                   Publisher                Year   #Copies Author/Month    ISBN/Issue");
        for (int i = 0; i < count; i++) {
            System.out.println(titles[i].toString());
        }
    }

    public Title findTitleByCallNumber(String callNumber) throws InvalidCallNumberException {
        for (int i = 0; i < count; i++) {
            if (titles[i].getCallNumber().equals(callNumber)) {
                return titles[i];
            }
        }
        throw new InvalidCallNumberException("No title found with call number " + callNumber);
    }

    public void findTitlesByTitle(String title) {
        boolean found = false;
        System.out.println("Titles found with the title: " + title);
        for (int i = 0; i < count; i++) {
            if (titles[i].getTitle().equals(title)) {
                System.out.println(titles[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No titles found with the title: " + title);
        }
    }

    public void findTitlesByYear(int year) {
        boolean found = false;
        System.out.println("Titles found for the year " + year + ":");
        for (int i = 0; i < count; i++) {
            if (titles[i].getYear() == year) {
                System.out.println(titles[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No titles found for the year " + year);
        }
    }

    public void saveTitles(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                writer.println(titles[i].toFileString());
            }
            System.out.println(count + " titles saved to \"" + filename + "\"");
        } catch (IOException e) {
            System.err.println("Error saving titles to file: " + e.getMessage());
        }
    }

    public void readTitles(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                addTitle(createTitleFromString(line));
            }
            System.out.println(count + " titles read from \"" + filename + "\"");
        } catch (FileNotFoundException e) {
            System.err.println("Error reading titles from file: " + e.getMessage());
        }
    }

    public void removeTitle(String callNumber) {
        int index = findTitleIndexByCallNumber(callNumber);
        if (index != -1) {
            // Shift titles to remove the found title
            for (int j = index; j < count - 1; j++) {
                titles[j] = titles[j + 1];
            }
            count--;
            System.out.println("Title with call number " + callNumber + " found and removed successfully.");
        } else {
            System.out.println("Title with call number " + callNumber + " not found.");
        }
    }

    private Title createTitleFromString(String line) {
        String[] parts = line.split("\\|"); // Assuming "|" as the delimiter
        String callNumber = parts[0];
        String title = parts[1];
        String publisher = parts[2];
        int year = Integer.parseInt(parts[3]);
        int copies = Integer.parseInt(parts[4]);

        if (parts.length == 7) {
            String authorOrMonth = parts[5];
            String isbnOrIssue = parts[6];
            return new Book(callNumber, title, publisher, year, copies, authorOrMonth, isbnOrIssue);
        } else if (parts.length == 6) {
            String month = parts[5];
            int issue = Integer.parseInt(parts[6]);
            return new Periodical(callNumber, title, publisher, year, copies, month, issue);
        }

        return null;
    }

    private void addTitle(Title newTitle) {
        if (count < titles.length) {
            titles[count++] = newTitle;
        } else {
            Title[] newTitlesArray = Arrays.copyOf(titles, titles.length * 2);
            titles = newTitlesArray;
            titles[count++] = newTitle;
        }
    }

    private int findTitleIndexByCallNumber(String callNumber) {
        for (int i = 0; i < count; i++) {
            if (titles[i].getCallNumber().equals(callNumber)) {
                return i;
            }
        }
        return -1;  // Title not found
    }

    public void checkCallNumberFormat(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCallNumberFormat'");
    }

    public void sortTitlesByYear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortTitlesByYear'");
    }
}
