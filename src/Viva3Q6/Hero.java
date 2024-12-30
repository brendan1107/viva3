package Viva3Q6;

public class Hero {
    String name;
    String element;
    double hp;
    double attack;
    String weakness;
    String resistance;
    int rsMultiplier;

    Hero(String name, String element, double hp, double attack) {
        this.name = name;
        this.element = checkElement(element);
        if (this.element == null) {
            throw new IllegalArgumentException("Invalid element: " + element);
        }
        this.hp = roundToHalf(hp);
        this.attack = roundToHalf(attack);
        this.rsMultiplier=0;
        setWeakness();
        setResistance();
    }

    String getElement() {
        return element.toUpperCase();
    }

    String checkElement(String element) {
        String[] predefinedElements = {"FIRE", "EARTH", "WATER", "LIGHT", "DARK"};
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
        if (getElement() == null) {
            System.err.println("Error setting weakness: Element is null");
            return;
        }
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
        if (getElement() == null) {
            System.err.println("Error setting resistance: Element is null");
            return;
        }

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

    double getHP() {
        return hp;
    }

    double getAttack() {
        return attack;
    }

    public String toString() {
        return String.format("Name: %s" +
                        "\nElement: %s" +
                        "\nHP: %.1f" +
                        "\nAttack: %.1f"
                , getName(), getElement(), getHP(), getAttack());

    }

    double calculateDamage(Villain enemy, int rsMultiplier) {
        double dominanceMultiplier = 1;

        if(this.element.equalsIgnoreCase(enemy.getWeakness())) {
            dominanceMultiplier =1.5;
        } else if(this.element.equalsIgnoreCase(enemy.getResistance())) {
            dominanceMultiplier = 0.5;
        }


        return Math.max(1, roundToHalf(this.attack * dominanceMultiplier *rsMultiplier - enemy.getdefence()));
    }

    double roundToHalf(double value) {
        return Math.round(value * 2) / 2.0;
    }
}

