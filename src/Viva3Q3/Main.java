package Viva3Q3;
import java.util.*;

class Pet {
    String name;
    String species;
    String breed;
    int age;
    String healthRecord;
    boolean isAdopted;
    String adopterName;

    public Pet(String name, String species, String breed, int age, String healthRecord) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthRecord = healthRecord;
        this.isAdopted = false;
        this.adopterName = null;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void adopt(String adopterName) {
        if (!isAdopted) {
            this.isAdopted = true;
            this.adopterName = adopterName;
            System.out.println(name + " has been adopted by " + adopterName + ".");
        } else {
            System.out.println(name + " is adopted.");
        }
    }

    public String getDetails() {
        return String.format("Name: %s\nSpecies: %s\nBreed: %s\nAge: %d\nHealthRecord: %s\nAdopted: %s\nAdopterName: %s\n",
                name, species, breed, age, healthRecord, isAdopted ? "Adopted" : "Not Adopted", adopterName);
    }
}

class Adopter {
    String name;
    String preferredSpecies;
    String preferredAgeRange;

    public Adopter(String name, String preferredSpecies, String preferredAgeRange) {
        this.name = name;
        this.preferredSpecies = preferredSpecies;
        this.preferredAgeRange = preferredAgeRange;
    }

    public void viewMatchingPets(PetAdoptionCentre centre) {
        String[] ageRange = preferredAgeRange.split("-");
        int minAge = Integer.parseInt(ageRange[0]);
        int maxAge = Integer.parseInt(ageRange[1]);

        for (Pet pet : centre.getAvailablePets()) {
            if (pet.getSpecies().equalsIgnoreCase(preferredSpecies) && pet.getAge() >= minAge && pet.getAge() <= maxAge) {
                System.out.println(pet.getDetails());
            }
        }
    }
}

class PetAdoptionCentre {
    private List<Pet> pets;

    public PetAdoptionCentre() {
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void adoptPet(Pet pet, Adopter adopter) {
        if (pet != null && !pet.isAdopted()) {
            pet.adopt(adopter.name);
        } else {
            System.out.println("Pet is either not found or already adopted.");
        }
    }
    public List<Pet> getAvailablePets() {
        List<Pet> availablePets = new ArrayList<>();
        for (Pet pet : pets) {
            if (!pet.isAdopted()) {
                availablePets.add(pet);
            }
        }
        return availablePets;
    }
    public void viewAvailablePets() {
        List<Pet> availablePets = getAvailablePets();
        for (Pet pet : availablePets) {
            System.out.println(pet.getDetails());
        }
    }

    public Pet getPetByName(String petName) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                return pet;
            }
        }
        System.out.println("Pet with name " + petName + " not found.");
        return null;
    }

   
}

public class Viva3q3{
public static void main(String[] args) {
        PetAdoptionCentre centre = new PetAdoptionCentre();

        // Adding pets to the centre
        centre.addPet(new Pet("Buddy", "Dog", "Labrador", 3, "Healthy"));
        centre.addPet(new Pet("Whiskers", "Cat", "Siamese", 2, "Vaccinated"));

        // Viewing available pets
        System.out.println("Available pets:");
        centre.viewAvailablePets();

        // Adopter matching and adoption process
        Adopter adopter1 = new Adopter("John", "Dog", "1-4");
        System.out.println("\nMatching pets for John:");
        adopter1.viewMatchingPets(centre);

        System.out.println("\nJohn adopts Buddy:");
        centre.adoptPet(centre.getPetByName("Buddy"), adopter1);

        System.out.println("\nAvailable pets after adoption:");
        centre.viewAvailablePets();
    }
}
