package Viva3Q6;

import java.util.Random;

public class Tester {
    public static void main(String[] args) throws InterruptedException {

        Hero molly = new Hero("Molly", "Water", 45, 20);
        Hero sean = new Hero("Sean", "Fire", 36, 24);
        Hero duncan = new Hero("Duncan", "Earth", 53, 16);
        Hero nathaniel = new Hero("Nathaniel", "Light", 37, 24);
        Hero endor = new Hero("Endor", "Dark", 43, 21);
        Hero urd = new Hero("Urd", "Water", 65, 17);
        Hero skuld = new Hero("Skuld", "Fire", 66, 16);
        Hero verthandi = new Hero("Verthandi", "Earth", 74, 13);
        Hero idun = new Hero("Idun", "Light", 59, 19);
        Hero valkyrie = new Hero("Valkyrie", "Dark", 61, 18);
        Hero poseidon = new Hero("Poseidon", "Water", 58, 19);
        Hero hephaestus = new Hero("Hephaestus", "Fire", 51, 22);
        Hero athena = new Hero("Athena", "Earth", 61, 18);
        Hero apollo = new Hero("Apollo", "Light", 55, 16);
        Hero artemis = new Hero("Artemis", "Dark", 50, 23);

        Hero[] heroes = {molly, sean, duncan, nathaniel, endor, urd, skuld,
                verthandi, idun, valkyrie, poseidon, hephaestus, athena, apollo, artemis};


        Villain[] villains = {
                new Villain("Giemsa", "Water", 100, 150, 15, 2),
                new Villain("Diablo", "Fire", 120, 163, 13, 3),
                new Villain("Nidhogg", "Earth", 130, 189, 11, 4),
                new Villain("Lucifer", "Light", 110, 207, 17, 3),
                new Villain("Odin", "Dark", 135, 196, 14, 5),
        };

        Game game = new Game();
        Random rd = new Random();
        Team team = new Team(heroes);
        team.formTeam();

        System.out.println("Heroes: ");
        int count =1;
        for(Hero hero: team.getHeroList()) {
            System.out.println("Hero "+count);
            System.out.println(hero.toString()+"\n");
            count++;
        }
        System.out.println();
        Villain randomVillain = villains[rd.nextInt(villains.length)];

        System.out.println("Villain: ");
        System.out.println(randomVillain.toString());
        System.out.println();

        game.battle(team, randomVillain);
    }
}