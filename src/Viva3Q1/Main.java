package viva3q1;

import java.util.ArrayList;

public class PotionTest {
    public static void main(String[] args) {
     PotionContainer container = new PotionContainer(); // create object for PotionContainer
     System.out.println("Adding potions to the container...");
     // add potion
     container.addPotion("Unicorn Tears", 200.0); // add to Ingredients ArrayList and Volume ArrayList
     container.addPotion("Dragon Blood", 150.0);
     System.out.println("Potion container successfully initialized.\n");
     
     
     System.out.println("=== Using Potions ===");
     // use potion
     container.usePotion("Unicorn Tears", 50.0); // get volume from Volume ArrayList and minus
     System.out.println("Remaining volume of Unicorn Tears: "+container.getRemainingVolume("Unicorn Tears") + " ml"); // 150
     
     container.usePotion("Dragon Blood", 30.0); // minus 30 from added
     System.out.println("Remaining volume of Dragon Blood: "+container.getRemainingVolume("Dragon Blood") + " ml");
     
     System.out.println("\nAttempting to use more Dragon Blood than available...");
     // attempt to use more potion
     container.usePotion("Dragon Blood", 200.0); // 200.0 is the amount will be deducted
     System.out.println("Remaining volume of Dragon Blood: " +container.getRemainingVolume("Dragon Blood") + " ml");
     
     
     System.out.println("\n=== Checking Potion Availability for Invisibility Draught ===");
     double requiredUnicornTears = 200.0; // volume1
     double requiredDragonBlood = 150.0; // volume2
     boolean readyForInvisibilityDraught=container.isEnoughForPotion(requiredUnicornTears, requiredDragonBlood);
     System.out.println("\nCan prepare Invisibility Draught?");
     if (readyForInvisibilityDraught) {
     System.out.println("Yes, we have enough Unicorn Tears and Dragon Blood!");
     } 
     else {
     System.out.println("No, we do not have enough ingredients to prepare the Invisibility Draught.");
}
     
     System.out.println("\nFinal state of the potion container:");
     System.out.println("\n--- Potion Inventory ---");
     container.printPotions();
    }
}

// parent class
class Potion{
  protected double volume;
  protected double remaining;
  protected double usage;
  
  public Potion(){
  }
  
  public double CalculateConsumeIngredient(){
     volume=volume-usage;
     return volume;
  } 
 
}

// subclass 
class PotionContainer extends Potion{
    // arrayList act as inventory 
    private ArrayList<Double> Volume=new ArrayList<>(); 
    private ArrayList<String> Ingredients=new ArrayList<>();
   
    public PotionContainer() {
   }
   
   public void addPotion(String potion,double volume){
       Volume.add(volume);
       Ingredients.add(potion); 
       // both use the same index
       System.out.println(volume+" ml of "+potion+" is added to the container.");
   }
   
   // check if potions enough
   // use it if enough 
   public void usePotion(String potion,double volume){
       usage=volume; 
       for (int i=0;i<Ingredients.size();i++){ // find for ingredient(dragon blood/unicorn tears)
         if(potion.equalsIgnoreCase(Ingredients.get(i))){
             
             if(potion.equalsIgnoreCase("Dragon Blood") && Volume.get(i)<150){ // check whether enough to user
                   System.out.println("Not Enough Dragon Blood available.");
             }
             else if(potion.equalsIgnoreCase("Unicorn Tears") && Volume.get(i)<200){
                 System.out.println("Not Enough Unicorn Tears available."); 
             }
             else if(potion.equalsIgnoreCase("Dragon Blood") && Volume.get(i)>=150 ||
                     potion.equalsIgnoreCase("Unicorn Tears") && Volume.get(i)>= 200){ 
                 this.volume=Volume.get(i);
                 System.out.println(volume+" ml of "+potion+" used.");
                 Volume.set(i,CalculateConsumeIngredient()); //modify the element (update the remainings)
             }
       }
       }
     
   }
   
   // get remainings of a specific potion
   public double getRemainingVolume(String potion){
     for(int i=0;i<Ingredients.size();i++){
       if(potion.equals(Ingredients.get(i))){
         remaining=Volume.get(i);
         break;
       }
     }
     return remaining;
   }
   
   // determine the remaining potion is enough for next magic potion
   public boolean isEnoughForPotion(double volume1,double volume2){
     boolean enough=false;  // to check if both potion enough 
     boolean tearsEnough=false; // to check whether unicorn tears remaining enough or not
     boolean bloodEnough=false; // to check whether dragon blood remaining enough or not
     for(int i=0;i<Ingredients.size();i++){
       if(Ingredients.get(i).equals("Unicorn Tears")){
           if(Volume.get(i)>=volume1){ // set the first parameter for unicorn tears
             tearsEnough= true;
           }}
       else if(Ingredients.get(i).equals("Dragon Blood")){
           if(Volume.get(i)>=volume2){ // set the second parameter for dragon blood
             bloodEnough= true;
           }
           
       }
   }
     
     if(tearsEnough==true && bloodEnough==true){
       enough=true;
     }
     return enough;
   }

   // print the remainings of each potion
    public void printPotions(){
     for(int i=0;i<Ingredients.size();i++){
        System.out.printf("%s : %.2f %s%n",Ingredients.get(i),Volume.get(i),"ml");
    }
   }}


