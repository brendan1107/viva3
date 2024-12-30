package Viva3Q6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Team {

    String teamName;
    List<Hero> deck;
    List<Hero> heroList = new ArrayList<>();
    int teamMaxHP = 0;
    int teamHP;

    Team(Hero[] heroes) {
        deck = new ArrayList<>(List.of(heroes));

    }

    void formTeam() {
        if(heroList!=null && !heroList.isEmpty()) {
            heroList.clear();
        }

        Collections.shuffle(deck);
        heroList.addAll(deck.subList(0, 4));

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
    List<Hero> getHeroList() {
        return heroList;
    }

    void getDamaged(int damage) {
        teamHP-=damage;
        teamHP = Math.max(teamHP,0);
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

    String getTeamName() {
        return teamName;
    }

     List<Hero> getHeroes() {
        return heroList;
    }
}
