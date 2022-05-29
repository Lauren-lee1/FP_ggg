import java.util.ArrayList;

public class Woo{
  /*
  Create a queue?stack?list? of men that the player can play through
  */
  public static void main(String[] arg){
    ArrayList<Person> reverseHarem = new ArrayList<Person>();
    // reverseHarem.add(boy1);
    // reverseHarem.add(boy2);
    // reverseHarem.add(boy3);
    for (Person i : reverseHarem){
      i.setStory();
      i.play();
    }

  }

}
