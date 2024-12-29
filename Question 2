
public class Zoo {

    private Creature[] creatureArray;

    private int creature_number;

    //Default value i = 0
    //When creature is added , i will increase.
    //If i is more than creature_number
    private int i;

    public Zoo(int creature_number){

        this.creature_number = creature_number;
        this.creatureArray = new Creature[this.creature_number];

    }

    public void addCreature(String species , double magicPower , String habitat){
        //If I was more than creature_number , then it will not add a new creature.
        if(this.i < this.creature_number){
        Creature creature = new Creature(species ,magicPower , habitat);

        creatureArray[this.i] = creature;

        System.out.println(creature.getSpecies() + " is added to the zoo.");

        this.i = this.i + 1;
        }


        else
            System.out.println("Zoo is full! Cannot add more creatures!");
    }

    public void displayAllCreatures() {
        for (Creature i : creatureArray){
            i.displayInfo();
            System.out.println();
        }
    }

    public void feedCreature(String species , double magicPower){

        int error = 0 ;
        for (int i = 0 ; i < this.creature_number ; i ++ ){
            if (creatureArray[i].getSpecies().equals(species)){
                creatureArray[i].feed(magicPower);
                System.out.println(creatureArray[i].getSpecies() + "'s magic power increased to " + creatureArray[i].getMagicPower() + ".");
            }
            else {
                error++;
                continue;
            }
        }

        if (error == this.creature_number  ){
            System.out.println("The species is not found!");
        }

    }
}
