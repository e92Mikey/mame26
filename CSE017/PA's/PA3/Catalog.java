import java.io.*;
import java.util.*;

public class Catalog {
     private static final int MAX_TITLES = 100;
    private Title[] titles;
    private int count;
    private RTitle[] restoredTitles;
    private int rcount;

    public Catalog() {
        titles = new Title[MAX_TITLES];
        restoredTitles = new RTitle[25];
        count = 0;
        rcount = 0;
    }

    public int getTitleCount() {
        return count;
    }

    public Title[] findTitlesByTitle(String title) {
        // implementation for finding titles by title
        if (title == null) {
            return null;
        }

        List<Title> matchingTitles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (titles[i] != null && titles[i].getTitle() != null && titles[i].getTitle().contains(title)) {
                matchingTitles.add(titles[i]);
            }
        }

        if (matchingTitles.isEmpty()) {
            return null; // No titles found
        }

        return matchingTitles.toArray(new Title[0]);
    }

    public void addTitle(Title title) {
        // implementation to add a title to the catalog
        if (count < MAX_TITLES) {
            titles[count] = title;
            count++;
        } else {
            System.out.println("Catalog is full. Cannot add more titles.");
        }
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

    public Title[] findTitlesByYear(int year) {
        // implementation for finding titles by year
        List<Title> titlesInYear = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (titles[i] != null && titles[i].getYear() == year) {
                titlesInYear.add(titles[i]);
            }
        }

        if (titlesInYear.isEmpty()) {
            return new Title[0]; // Return an empty array if no titles found
        }

        return titlesInYear.toArray(new Title[0]);
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

    private int findTitleIndexByCallNumber(String callNumber) {
        for (int i = 0; i < count; i++) {
            if (titles[i].getCallNumber().equals(callNumber)) {
                return i;
            }
        }
        return -1;  // Title not found
    }

    public void checkCallNumberFormat(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'checkCallNumberFormat'");
    }

    public void sortTitlesByYear() {
        throw new UnsupportedOperationException("Unimplemented method 'sortTitlesByYear'");
    }

    public boolean findRestored(Title title) {
    for (RTitle restoredTitle : restoredTitles) {
        if (restoredTitle != null && restoredTitle.getRestoredTitle().equals(title)) {
            return true;
        }
    }
    return false;
}
    public void sort() {
    Arrays.sort(titles, 0, count);
}
    public void viewRestorable() {
    System.out.println("Restorable Titles:");
    for (Title title : titles) {
        if (title != null && title.isRestorable() && !findRestored(title)) {
            System.out.println(title.toString());
        }
    }
}
    public void restore() {
    for (Title title : titles) {
        if (title != null && title.isRestorable() && !findRestored(title)) {
            RTitle rTitle = new RTitle(title);
            restoredTitles[rcount++] = rTitle;
            System.out.println(title.getTitle() + " has been restored.");
        }
    }
}
}
