package viva3q1;

import java.util.ArrayList;

public class PotionTest {
    public static void main(String[] args) {
     PotionContainer container = new PotionContainer(); // create object for PotionContainer
     System.out.println("Adding potions to the container...");
     container.addPotion("Unicorn Tears", 200.0); 
     container.addPotion("Dragon Blood", 150.0);
     System.out.println("Potion container successfully initialized.\n");
     
     
     System.out.println("=== Using Potions ===");
     container.usePotion("Unicorn Tears", 50.0); // minus 50 from added 
     System.out.println("Remaining volume of Unicorn Tears: "+container.getRemainingVolume("Unicorn Tears") + " ml"); // 150
     
     container.usePotion("Dragon Blood", 30.0); // minus 30 from added
     System.out.println("Remaining volume of Dragon Blood: "+container.getRemainingVolume("Dragon Blood") + " ml");
     
     System.out.println("\nAttempting to use more Dragon Blood than available...");
     container.usePotion("Dragon Blood", 200.0);
     System.out.println("Remaining volume of Dragon Blood: " +container.getRemainingVolume("Dragon Blood") + " ml");
     
     
     System.out.println("\n=== Checking Potion Availability for Invisibility Draught ===");
     double requiredUnicornTears = 200.0;
     double requiredDragonBlood = 150.0;
     boolean readyForInvisibilityDraught=container.isEnoughForPotion(requiredUnicornTears, requiredDragonBlood);
     System.out.println("\nCan prepare Invisibility Draught?");
     if (readyForInvisibilityDraught) {
     System.out.println("Yes, we have enough Unicorn Tears and Dragon Blood!");
     } else {
     System.out.println("No, we do not have enough ingredients to prepare the Invisibility Draught.");
}
     
     System.out.println("\nFinal state of the potion container:");
     System.out.println("\n--- Potion Inventory ---");
     container.printPotions();
    }
}


class Potion{
  protected String ingredient;
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

class PotionContainer extends Potion{
    private ArrayList<Double> Volume=new ArrayList<>();
    private ArrayList<String> Ingredients=new ArrayList<>();
   
    public PotionContainer() {
   }
   
   public void addPotion(String potion,double volume){
       Volume.add(volume);
       Ingredients.add(potion);       
       System.out.println(volume+" ml of "+potion+" is added to the container.");
   }
   
   public void usePotion(String potion,double volume){
       usage=volume;
       for (int i=0;i<Ingredients.size();i++){
         if(potion.equals(Ingredients.get(i))){
           this.volume=Volume.get(i);
           if(potion.equals("Dragon Blood") && Volume.get(i)<150){ // check whether enough to user
           System.out.println("Not Enough Dragon Blood available.");
           }
           else if(potion.equals("Unicorn Tears") && Volume.get(i)<200){
           System.out.println("Not Enough Unicorn Tears available."); 
           }
           else{
           System.out.println(volume+" ml of "+potion+" used.");
           Volume.set(i,CalculateConsumeIngredient());
         }
       }
       }
     
   }
   
   public double getRemainingVolume(String potion){
     for(int i=0;i<Ingredients.size();i++){
       if(potion.equals(Ingredients.get(i))){
         remaining=Volume.get(i);
         break;
       }
     }
     return remaining;
   }
   
   public boolean isEnoughForPotion(double volume1,double volume2){
     boolean enough=false;
     for(int i=0;i<Ingredients.size();i++){
       if(Ingredients.get(i).equals("Unicorn Tears")){
           if(Volume.get(i)>=volume1){
             enough= true;
           }}
       else if(Ingredients.get(i).equals("Dragon Blood")){
           if(Volume.get(i)>=volume2){
             enough= true;
           }
           
       }

     
   }
     return enough;
   }

    public void printPotions(){
     for(int i=0;i<Ingredients.size();i++){
        System.out.printf("%s : %.2f%n",Ingredients.get(i),Volume.get(i));
    }
   }}


