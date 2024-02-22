/**
 * Tests the implementations of the classes.
 */
public class LibraryTest {
    public static void main(String[] args) {
        // Test case 1: create a new catalog
        Catalog myLibrary = new Catalog();
        System.out.println("Test case 1: create a new catalog");
        System.out.println("A new catalog was created with 0 titles\n");

        // Test case 2: add new titles
        System.out.println("Test case 2: add new titles");
        myLibrary.addTitle(new Book("B-111-111-111", "Introduction to Java Programming", "Pearson", 2021, 10, "M. Savitch", 9876579310L));
        myLibrary.addTitle(new Book("B-222-111-111", "Programming and Data Structures", "McGraw Hill", 2018, 5, "Brian Lang", 9878879310L));
        myLibrary.addTitle(new Book("B-222-333-111", "Introduction to C Language", "Wiley", 2005, 2, "James Foster", 1203324661L));
        myLibrary.addTitle(new Book("B-222-222-222", "Introduction to Java Programming", "Cengage", 2018, 2, "G. Albert", 9876759310L));
        myLibrary.addTitle(new Periodical("P-111-222-333", "ACM Transactions on Algorithms", "ACM", 2005, 5, Month.SEPTEMBER, 2));
        myLibrary.addTitle(new Periodical("P-111-111-333", "ACM Transactions on Communications", "ACM", 2005, 2, Month.JULY, 1));
        myLibrary.addTitle(new Periodical("P-111-111-111", "IEEE Software", "IEEE Computer Society", 1983, 1, Month.JUNE, 3));
        myLibrary.addTitle(new Periodical("P-222-111-333", "IEEE Spectrum", "IEEE Computer Society", 2020, 1, Month.SEPTEMBER, 1));

        // Print the number of titles added
        System.out.println(myLibrary.getCount() + " titles added to myLibrary\n");

        // Test case 3: view all titles
        System.out.println("Test case 3: view all titles");
        System.out.println(myLibrary.toString());

        // Test case 4: find title by call number (successful)
        System.out.println("Test case 4: find title by call number (successful)");
        Title foundTitle = myLibrary.findCallN("B-111-111-111");
        if (foundTitle != null) {
            System.out.println("Title found with call number " + foundTitle.callN + ":");
            System.out.println(foundTitle.toString() + "\n");
        } else {
            System.out.println("No title found with call number B-111-111-111\n");
        }

        // Test case 5: find title by call number (fail)
        System.out.println("Test case 5: find title by call number (fail)");
        Title notFoundTitle = myLibrary.findCallN("B-333-333-333");
        if (notFoundTitle != null) {
            System.out.println("        Title found with call number " + notFoundTitle.callN + ":");
            System.out.println(notFoundTitle.toString() + "\n");
        } else {
            System.out.println("No title found with call number B-333-333-333\n");
        }

        // Test case 6: find titles by title (one title found)
        System.out.println("Test case 6: find titles by title (one title found)");
        Title[] titlesByTitle = myLibrary.findTitle("Programming and Data Structures");
        if (titlesByTitle != null && titlesByTitle.length > 0) {
            System.out.println("One title found with the title: Programming and Data Structures");
            for (Title t : titlesByTitle) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found with the title: Programming and Data Structures\n");
        }

        // Test case 7: find titles by title (more than one title found)
        System.out.println("Test case 7: find titles by title (more than one title found)");
        Title[] multipleTitlesByTitle = myLibrary.findTitle("Introduction to Java Programming");
        if (multipleTitlesByTitle != null && multipleTitlesByTitle.length > 0) {
            System.out.println(multipleTitlesByTitle.length + " titles found with the title: Introduction to Java Programming");
            for (Title t : multipleTitlesByTitle) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found with the title: Introduction to Java Programming\n");
        }

        // Test case 8: find titles by title (no title found)
        System.out.println("Test case 8: find titles by title (no title found)");
        Title[] noTitlesByTitle = myLibrary.findTitle("Introduction to Python");
        if (noTitlesByTitle != null && noTitlesByTitle.length > 0) {
            System.out.println("Titles found with the title: Introduction to Python");
            for (Title t : noTitlesByTitle) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found with the title: Introduction to Python\n");
        }

        // Test case 9: find titles by year (one title found)
        System.out.println("Test case 9: find titles by year (one title found)");
        Title[] titlesByYear = myLibrary.findYear(2021);
        if (titlesByYear != null && titlesByYear.length > 0) {
            System.out.println("One title found for the year 2021:");
            for (Title t : titlesByYear) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found for the year 2021\n");
        }

        // Test case 10: find titles by year (more than one title found)
        System.out.println("Test case 10: find titles by year (more than one title found)");
        Title[] multipleTitlesByYear = myLibrary.findYear(2005);
        if (multipleTitlesByYear != null && multipleTitlesByYear.length > 0) {
            System.out.println(multipleTitlesByYear.length + " titles found for the year 2005:");
            for (Title t : multipleTitlesByYear) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found for the year 2005\n");
        }

        // Test case 11: find titles by year (no title found)
        System.out.println("Test case 11: find titles by year (no title found)");
        Title[] noTitlesByYear = myLibrary.findYear(2019);
        if (noTitlesByYear != null && noTitlesByYear.length > 0) {
            System.out.println("Titles found for the year 2019:");
            for (Title t : noTitlesByYear) {
                System.out.println(t.toString());
            }
            System.out.println();
        } else {
            System.out.println("No titles found for the year 2019\n");
        }

        // Test case 12: sort the titles by year
        System.out.println("Test case 12: sort the titles by year");
        myLibrary.sort();
        System.out.println(myLibrary.toString());

        // End of tests
        System.out.println("End of tests");
    }
}

