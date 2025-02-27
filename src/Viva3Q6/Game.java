package Viva3Q6;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public void battle(Team team, Villain enemy)  {
        team.resetTeamHp();
        enemy.resetHp();
        Random rd = new Random();
        ArrayList<String> runestone = new ArrayList<>();


        System.out.println("Battle start!");

        int round =1;

        while(true) {
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                continue;
            }

            System.out.println("\nRound "+ round+": ");
            for(int i =0; i<3;i++) {
                int random = rd.nextInt(5);
                switch(random) {
                    case 0-> runestone.add("FIRE");
                    case 1-> runestone.add("WATER");
                    case 2-> runestone.add("EARTH");
                    case 3-> runestone.add("LIGHT");
                    case 4-> runestone.add("DARK");
                    default-> System.err.println("Error generating runestone");
                }
            }


            System.out.println("Enemy's current CD: "+ enemy.getCurrentCd());
            System.out.println("Runestones dissolved:");
            for(String runestoneElement : runestone) {
                System.out.println("- " + runestoneElement);
            }
            System.out.println();

            for(Hero hero: team.getHeroList()) {
                for(String runestoneElement: runestone) {
                    if((hero.getElement()).equalsIgnoreCase(runestoneElement)) {
                        hero.rsMultiplier+=1;
                    }
                }
                if(hero.rsMultiplier!=0) {
                    try{
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        continue;
                    }                    hero.calculateDamage(enemy , hero.rsMultiplier);
                    double damage = hero.calculateDamage(enemy,hero.rsMultiplier);
                    enemy.getDamaged(damage);
                    System.out.println(hero.getName() +" dealt " + damage + " damage to " +enemy.getName());
                    hero.rsMultiplier =0;
                }
            }
            runestone.clear();

            if (enemy.getHp() == 0) {
                System.out.println("Team's remaining HP: " + team.getTeamHP());
                System.out.println("Enemy's remaining HP: " + enemy.getHp());
                System.out.println("The team won!");
                break;
            }

            try{
                Thread.sleep(150);
            } catch (InterruptedException e) {
                continue;
            }            if(enemy.getCurrentCd()==1) {
                double damage = enemy.getAttack();
                team.getDamaged(damage);
                System.out.println(enemy.getName() +" dealt " + damage +" damage to the team");
                enemy.resetCd();
            }
            enemy.decreaseCd();
            round++;

            System.out.println("Team's remaining HP: " +team.getTeamHP());
            System.out.println("Enemy's remaining HP: " +enemy.getHp());

            try{
                Thread.sleep(150);
            } catch (InterruptedException e) {
                continue;
            }
            if(team.getTeamHP()==0) {
                System.out.println("The enemy won!");
                break;
            } else if(enemy.getHp()==0) {
                System.out.println("The team won!");
                break;
            }
        }
    }

}