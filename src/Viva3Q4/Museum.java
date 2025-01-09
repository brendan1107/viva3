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
        // store information about the exhibit, such as its title, artist, year, type, and description.

        /* a constructor method that initializes an Exhibit object with 
        the provided values for title, artist, year, type, and description.
        */
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
            //returns a string containing the details of the exhibit, formatted with line breaks
        }

        // getter methods that return the values of the artist, type, and year instance variables, 
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
        try (BufferedReader br = new BufferedReader(new StringReader(data))) {//This is used to read the string line by line.
            String line;
            while ((line = br.readLine()) != null) {//This method reads a line of text. It returns null when the end of the stream is reached.
                String[] parts = line.split(";", 5); //This method splits the line into an array of strings based on the delimiter ;.
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    //trims it, converts it to an integer, and assigns it to the year variable.
                    String type = parts[3].trim();
                    String description = parts[4].trim();
                    exhibits.add(new Exhibit(title, artist, year, type, description));
                    //creates a new Exhibit object using the extracted values and adds it to the exhibits list.
                }
            }
        } catch (IOException e) {//This block catches any IOException that might occur during the reading process.
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
                //If a match is found, it prints the details of the exhibit using the getDetails method.
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

    // Main method to run the program,
    //The main method creates a Museum object, loads exhibits from a hardcoded string,
    //and demonstrates various functionalities like viewing all exhibits and searching by artist, type, and year.
    public static void main(String[] args) {
        Museum museum = new Museum();

        // Hardcoded example exhibits data,contains 3 exhibits
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
