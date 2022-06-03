package v4alt;
import java.util.ArrayList;

public class Player extends Character{
ArrayList<Item> inventory;
  double money;
  //public int _desirability

  public Player(String name){
    super(name);
    inventory = new ArrayList<Item>();
    money = 0;
  }

  public void printStats() {
    System.out.println(_name + " | $" + money);
    System.out.println("=================");
    System.out.println("confidence: " + _confidence);
    System.out.println("intelligence: " + _intelligence);
    System.out.println("kindness: " + _kindness);
    System.out.println("=================");
  }

  public double getAffection(LoveInterest lover) {
      return -1;
  }

  public void giveItem(LoveInterest lover) {
      lover.receiveItem();
  }
  
  public void buyItem(Item item) {
      if (money > item.getPrice()) {
        inventory.add(item);
        money -= item.getPrice();
      } else {
        System.out.println("lol u broke");
      }

  }
  
  public String getInventory() {
      String output = "[";

      for (Item item: inventory) {
          output += item.toString();
          output += ", ";
      }

      output = output.substring(0, output.length() - 2);
      output += "]";

      return output;
  }
}
