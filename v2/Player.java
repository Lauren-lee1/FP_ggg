import java.util.ArrayList;

public class Player extends Character{
  String _gender;
  ArrayList<Item> inventory;
  double money;
  //public int _desirability

  public Player(String name, String gender){
    super(name);
    _gender = gender;
    inventory = new ArrayList<Item>();
    money = 0;
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

  public String getGender() {
      return _gender;
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
