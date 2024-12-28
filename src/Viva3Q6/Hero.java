package Viva3Q6;

public class Hero {
    String name;
    String element;
    int hp;
    int attack;
    String[] predefinedElements = {"FIRE", "EARTH", "WATER", "LIGHT", "DARK"};
    String weakness;
    String resistance;

    Hero(String name, String element, int hp, int attack) {
        this.name = name;
        this.element = checkElement(element);
        this.hp = hp;
        this.attack = attack;
        setWeakness();
        setResistance();
    }

    String getElement() {
        return element;
    }

    String checkElement(String element) {
        for (String ele : predefinedElements) {
            if (element.equalsIgnoreCase(ele)) {
                return element.toUpperCase();
            }
        }
        return null;
    }

    //the weakness of an element is the element that
    // deals 1.5 times damage to them
    void setWeakness() {
        switch (getElement()) {
            case "FIRE" -> this.weakness = "WATER";
            case "WATER" -> this.weakness = "EARTH";
            case "EARTH" -> this.weakness = "FIRE";
            case "LIGHT" -> this.weakness = "DARK";
            case "DARK" -> this.weakness = "LIGHT";
            default -> System.err.println("Error setting weakness");
        }
    }

    //if an element resist another, that means the other element
    // deals half the damage to an element
    void setResistance() {
        switch (getElement()) {
            case "FIRE" -> this.resistance = "EARTH"; //fire resist
            case "EARTH" -> this.resistance = "WATER";
            case "WATER" -> this.resistance = "FIRE";
            case "LIGHT", "DARK" -> this.resistance = null;
            default -> System.err.println("Error setting resistance");
        }
    }

    String getName() {
        return name;
    }

    int getHP() {
        return hp;
    }

    int getAttack() {
        return attack;
    }

    public String toString() {
        return String.format("\nName: %s" +
                        "\nElement: %s" +
                        "\n HP: %d" +
                        "\n Attack: %d"
                , getName(), getElement(), getHP(), getAttack());

    }

    void calculateDamage(Villain enemy, int rsMultiplier) {

    }


}
