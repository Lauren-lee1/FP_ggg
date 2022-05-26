public class Woo{
  /*
  Create a queue?stack?list? of men that the player can play through
  */
  public static void main(String[] arg){
    ArrayList<Men> reverseHarem = new ArrayList<Men>();
    // reverseHarem.add(boy1);
    // reverseHarem.add(boy2);
    // reverseHarem.add(boy3);
    for (Men i : reverseHarem){
      i.setStory();
      i.play();
    }

  }

}
