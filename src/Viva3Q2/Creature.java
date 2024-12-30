
public class Creature {

    private String species;
    private  double magicPower;
    private String habitat;

    public Creature(String species , double magicPower , String habitat){
        this.species = species;
        this.magicPower = magicPower;
        this.habitat = habitat;
    }

    public void feed(double foodAmount ){
        this.magicPower = this.magicPower + foodAmount;
    }

    public void displayInfo(){
        System.out.print("Species: ");
        System.out.println(this.species);
        System.out.print("Magic Power: ");
        System.out.println(this.magicPower);
        System.out.print("Habitat: ");
        System.out.println(this.habitat);
    }

    public String getSpecies(){
        return this.species;
    }

    public double getMagicPower(){
        return this.magicPower;
    }
    public String getHabitat(){
        return this.habitat;
    }

}
