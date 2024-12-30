package Viva3Q6;

public class Villain {
    String name;
    String element;
    int maxHp;
    int hp;
    int attack;
    int defense;
    int initialCd;
    int currentCd;
    String weakness;
    String resistance;

    Villain(String name, String element, int maxHp, int attack, int defense, int initialCd ) {
        this.name = name;
        this.element = checkElement(element);
        if (this.element == null) {
            throw new IllegalArgumentException("Invalid element: " + element);
        }
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.initialCd = initialCd;

        setWeakness();
        setResistance();
        this.hp = maxHp;
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
    int getMaxHp() {
        return maxHp;
    }
    int getHp() {
        return hp;
    }
    int getAttack() {
        return attack;
    }
    int getDefense() {
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
    void setName(String name) {
        this.name = name;
    }
    void setElement(String element) {
        this.element = element;
    }
    void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    void setHp(int hp) {
        this.hp = hp;
    }
    void setAttack(int attack) {
        this.attack = attack;
    }
    void setDefense(int defense) {
        this.defense = defense;
    }
    void setInitialCd(int initialCd) {
        this.initialCd = initialCd;
    }
    void setCurrentCd(int currentCd) {
        this.currentCd = currentCd;
    }
    void setWeakness(String weakness) {
        this.weakness = weakness;
    }
    void setResistance(String resistance) {
        this.resistance = resistance;
    }


    void getDamaged(int damage) {
        if((getHp()-damage)<0) {
            setHp(0);
        } else {
            setHp(getHp()-damage);
        }
// calculate remaining hp of
//the enemy after being attacked. If the remaining hp < 0, set the remaining hp to 0.
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
                            "\nMax HP: %d" +
                            "\nHP: %d" +
                            "\nAttack: %d" +
                            "\nDefense: %d\nCooldown: %d" +
                            "\nWeakness: %s" +
                            "\nResistance: %s",
                    getName(), getElement(), getMaxHp(), getHp(), getAttack(), getDefense(), getCurrentCd(), getWeakness(), getResistance());
    }
}
