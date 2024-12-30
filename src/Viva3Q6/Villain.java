package Viva3Q6;

public class Villain {
    String name;
    String element;
    double maxHp;
    double hp;
    double attack;
    double defense;
    int initialCd;
    int currentCd;
    String weakness;
    String resistance;

        Villain(String name, String element, double maxHp, double attack, double defense, int initialCd ) {
        this.name = name;
        this.element = checkElement(element);
        if (this.element == null) {
            throw new IllegalArgumentException("Invalid element: " + element);
        }
        this.maxHp = roundToHalf(maxHp);
        this.attack = roundToHalf(attack);
        this.defense = roundToHalf(defense);
        this.initialCd = initialCd;

        setWeakness();
        setResistance();
        this.hp = roundToHalf(maxHp);
        this.currentCd = initialCd;
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
    String getElement() {
        return element;
    }
    double getMaxHp() {
        return maxHp;
    }
    double getHp() {
        return hp;
    }
    double getAttack() {
        return attack;
    }
    double getDefense() {
        return defense;
    }
    int getInitialCd() {
        return initialCd;
    }
    int getCurrentCd() {
        return currentCd;
    }
    String getWeakness() {
        return weakness;
    }
    String getResistance() {
        return resistance;
    }
    void setHp(double hp) {
        this.hp = roundToHalf(hp);
    }void setCurrentCd(int currentCd) {
        this.currentCd = currentCd;
    }


    void getDamaged(double damage) {
        damage = roundToHalf(damage);
        setHp(roundToHalf(Math.max(0, getHp() - damage)));
    }

    void resetHp() {
        setHp(getMaxHp());
//to reset the villain’s hp.
    }

    void decreaseCd() {
        if(getCurrentCd()>1) {
            setCurrentCd(getCurrentCd()-1);
        } else if(getCurrentCd()==0) {
            resetCd();
        }
        //decrease the villain's currentCd at the end of each round.
    }

    void resetCd() {
        setCurrentCd(getInitialCd());
        //reset villain's currentCd after attacking
    }

    public String toString() {
            return String.format("Name: %s" +
                            "\nElement: %s" +
                            "\nMax HP: %.1f" +
                            "\nHP: %.1f" +
                            "\nAttack: %.1f" +
                            "\nDefense: %.1f\nCooldown: %d" +
                            "\nWeakness: %s" +
                            "\nResistance: %s",
                    getName(), getElement(), getMaxHp(), getHp(), getAttack(), getDefense(), getCurrentCd(), getWeakness(), getResistance());
    }

    double roundToHalf(double value) {
        return Math.round(value * 2) / 2.0;
    }
}
