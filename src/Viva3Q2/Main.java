public class Main {

    public static void main(String[] args ){

        Zoo myZoo = new Zoo(3);

        myZoo.addCreature("Panda" , 150.0 , "Mountains");
        myZoo.addCreature("Dragon" , 300.0 , "Cave");
        myZoo.addCreature("Master Oogway" , 200.0 , "Forest");

        myZoo.addCreature("Patrick Star", 250.0 , "Rock");

        myZoo.displayAllCreatures();
        myZoo.feedCreature("Dragon" , 50.0);
        myZoo.displayAllCreatures();
    }
}
