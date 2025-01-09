package museum;

// Import necessary classes
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Museum {
    // Nested Exhibit class to represent individual exhibits
    private static class Exhibit {
        private String title;
        private String artist;
        private int year;
        private String type;
        private String description;

        // Constructor to initialize an Exhibit object
        public Exhibit(String title, String artist, int year, String type, String description) {
            this.title = title;
            this.artist = artist;
            this.year = year;
            this.type = type;
            this.description = description;
        }

        // Method to get details of the exhibit
        public String getDetails() {
            return "Title: " + title + "\nArtist: " + artist + "\nYear: " + year +
                   "\nType: " + type + "\nDescription: " + description + "\n";
        }

        // Getter methods for artist, type, and year
        public String getArtist() { return artist; }
        public String getType() { return type; }
        public int getYear() { return year; }
    }

    // List to store all exhibits
    private List<Exhibit> exhibits;

    // Constructor to initialize the Museum object
    public Museum() {
        exhibits = new ArrayList<>();
    }

    // Method to load exhibits from a string (simulated loading)
    public void loadExhibitsFromString(String data) {
        try (BufferedReader br = new BufferedReader(new StringReader(data))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", 5); // Assuming ';' separates attributes
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String type = parts[3].trim();
                    String description = parts[4].trim();
                    exhibits.add(new Exhibit(title, artist, year, type, description));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }

    // Method to view all exhibits
    public void viewAllExhibits() {
        for (Exhibit exhibit : exhibits) {
            System.out.println(exhibit.getDetails());
        }
    }

    // Method to search exhibits by artist
    public void searchExhibitsByArtist(String artist) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.getArtist().equalsIgnoreCase(artist)) {
                System.out.println(exhibit.getDetails());
            }
        }
    }

    // Method to search exhibits by type
    public void searchExhibitsByType(String type) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.getType().equalsIgnoreCase(type)) {
                System.out.println(exhibit.getDetails());
            }
        }
    }

    // Method to search exhibits by year
    public void searchExhibitsByYear(int year) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.getYear() == year) {
                System.out.println(exhibit.getDetails());
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Museum museum = new Museum();

        // Hardcoded example exhibits data
        String exhibitsData = """
            The Starry Night; Vincent van Gogh; 1889; Painting; A depiction of the night sky.
            Mona Lisa; Leonardo da Vinci; 1504; Painting; A portrait of a woman with a mysterious smile.
            David; Michelangelo; 1504; Sculpture; A marble statue representing the Biblical hero David.
            """;

        // Load exhibits from the hardcoded data
        museum.loadExhibitsFromString(exhibitsData);

        // Display all exhibits
        System.out.println("All exhibits:");
        museum.viewAllExhibits();

        // Search and display exhibits by artist
        System.out.println("\nSearch exhibits by artist 'Vincent van Gogh':");
        museum.searchExhibitsByArtist("Vincent van Gogh");

        // Search and display exhibits by type
        System.out.println("\nSearch exhibits by type 'Painting':");
        museum.searchExhibitsByType("Painting");

        // Search and display exhibits by year
        System.out.println("\nSearch exhibits by year '1504':");
        museum.searchExhibitsByYear(1504);
    }
}
