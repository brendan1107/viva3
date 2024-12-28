package Viva3Q6;

import java.util.List;
import java.util.Random;

public class Team {

    String teamName;
    List<Hero> deck;
    List<Hero> heroList;
    int teamMaxHP = 0;
    int teamHP;

    Team(String teamName) {
        this.teamName = teamName;
        formTeam();
    }

    void formTeam() {
        {
            Hero hero1 = new Hero("Arthur", "FIRE", 100, 25);
            Hero hero2 = new Hero("Luna", "WATER", 90, 30);
            Hero hero3 = new Hero("Thor", "EARTH", 110, 35);
            Hero hero4 = new Hero("Selena", "LIGHT", 95, 28);
            Hero hero5 = new Hero("Zephyr", "DARK", 105, 32);
            Hero hero6 = new Hero("Ignis", "FIRE", 120, 40);
            Hero hero7 = new Hero("Oceanus", "WATER", 100, 33);
            Hero hero8 = new Hero("Gaia", "EARTH", 115, 37);
            Hero hero9 = new Hero("Celeste", "LIGHT", 90, 25);
            Hero hero10 = new Hero("Umbra", "DARK", 100, 30);
            deck.add(hero1);
            deck.add(hero2);
            deck.add(hero3);
            deck.add(hero4);
            deck.add(hero5);
            deck.add(hero6);
            deck.add(hero7);
            deck.add(hero8);
            deck.add(hero9);
            deck.add(hero10);
        }
        if(heroList!=null && !heroList.isEmpty()) {
            heroList.clear();
        }

        Random rd = new Random();
        for(int i =0; i<4;i++) {
            heroList.add(deck.get(rd.nextInt(10)));
        }
        for(Hero chosenHero : heroList) {
            this.teamMaxHP += chosenHero.getHP();
            this.teamHP = teamMaxHP;
        }

        // clear the heroList and randomly choose
        //4 heroes from the deck and add them into the heroList. Then, calculate the team’s
        //hp by summing hp of the heroes chosen.
    }


    int getTeamHP() {
        return teamHP;
    }
    int getTeamMaxHP() {
        return teamMaxHP;
    }
    void setTeamHP(int teamHP) {
        this.teamHP = teamHP;
    }

    void getDamaged(int damage) {
        if((getTeamMaxHP()-damage)<0) {
            setTeamHP(0);
        } else {
            setTeamHP(getTeamMaxHP()-damage);
        }
// calculate remaining hp of
//the team after being attacked. If the remaining hp < 0, set the remaining hp to 0.
    }

    void resetTeamHp() {
        setTeamHP(getTeamMaxHP());
        //• Create a method resetTeamHp() to reset the team’s hp.
    }

    public String toString() {
        String teamInfo = String.format("Team Name: %s\nHeroes:\n", getTeamName());

        for (Hero hero : getHeroes()) {
            teamInfo += String.format("%s\n", hero.toString());
        }

        return teamInfo;    }

    private String getTeamName() {
        return teamName;
    }

    private List<Hero> getHeroes() {
        return heroList;
    }
}
