public class LibraryManager {
    public static void main(String[] args) {
        Catalog myLibrary = new Catalog(100);

        // Test case 1: create a new catalog
        System.out.println("Test case 1: create a new catalog");
        System.out.println("A new catalog was created with 0 titles\n");

        // Test case 2: read titles from the file
        System.out.println("Test case 2: read titles from the file");
        myLibrary.readTitles("input.txt");
        System.out.println();

        // Test case 3: view all titles
        System.out.println("Test case 3: view all titles");
        // Assuming there is a method to print the titles in the required format
        myLibrary.viewAllTitles();
        System.out.println();

        // Test case 4: find title by call number (successful)
               System.out.println("Test case 4: find title by call number (successful)");
        try {
            Title foundTitle = myLibrary.findTitleByCallNumber("B-111-111-111");
            System.out.println("Title found with call number B-111-111-111:\n" + foundTitle.simpleToString() + "\n");
        } catch (InvalidCallNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test case 5: find title by call number (fail)
        System.out.println("Test case 5: find title by call number (fail)");
        try {
            Title notFoundTitle = myLibrary.findTitleByCallNumber("P-333-333-333");
            System.out.println("Title found with call number P-333-333-333:\n" + notFoundTitle.simpleToString() + "\n");
        } catch (InvalidCallNumberException e) {
            System.out.println("No title found with call number P-333-333-333\n");
        }

        // Test case 6: find title by call number (invalid call number)
        System.out.println("Test case 6: find title by call number (invalid call number)");
        myLibrary.checkCallNumberFormat("B-333-333");

        // Test case 7: find titles by title (one title found)
        System.out.println("Test case 7: find titles by title (one title found)");
        myLibrary.findTitlesByTitle("Computer Systems");
        System.out.println();

        // Test case 8: find titles by title (more than one title found)
        System.out.println("Test case 8: find titles by title (more than one title found)");
        myLibrary.findTitlesByTitle("Introduction to C language");
        System.out.println();

        // Test case 9: find titles by title (no title found)
        System.out.println("Test case 9: find titles by title (no title found)");
        myLibrary.findTitlesByTitle("Introduction to Python");
        System.out.println();

        // Test case 10: find titles by year (one title found)
        System.out.println("Test case 10: find titles by year (one title found)");
        myLibrary.findTitlesByYear(2021);
        System.out.println();

        // Test case 11: find titles by year (more than one title found)
        System.out.println("Test case 11: find titles by year (more than one title found)");
        myLibrary.findTitlesByYear(2020);
        System.out.println();

        // Test case 12: find titles by year (no title found)
        System.out.println("Test case 12: find titles by year (no title found)");
        myLibrary.findTitlesByYear(2017);
        System.out.println();

        // Test case 13: sort the titles by year
        System.out.println("Test case 13: sort the titles by year");
        myLibrary.sortTitlesByYear();
        // Assuming there is a method to print the sorted titles
        myLibrary.viewAllTitles();
        System.out.println();

        // Test case 14: remove a title (successful)
        System.out.println("Test case 14: remove a title (successful)");
        myLibrary.removeTitle("B-333-333-333");
        // Assuming there is a method to print the remaining titles
        myLibrary.viewAllTitles();
        System.out.println();

        // Test case 15: remove a title (failed)
        System.out.println("Test case 15: remove a title (failed)");
        myLibrary.removeTitle("B-666-666-666");
        System.out.println();

        // Test case 16: remove a title (invalid call number)
        System.out.println("Test case 16: remove a title (invalid call number)");
        myLibrary.removeTitle("P-123");

        // Test case 17: save titles to the text file
        System.out.println("Test case 17: save titles to the text file");
        myLibrary.saveTitles("output.txt");
        System.out.println();

        // Assuming there is a method to read titles from the saved file and print them
        myLibrary.readTitles("output.txt");
        myLibrary.viewAllTitles();
    }
}
