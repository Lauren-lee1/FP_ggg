import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Game{
  StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  Player _play;

  public Game(){
    Stinrg response = _scanner.nextLine();
      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("What is your name?");
      String name = _scanner.nextLine();
      _play = new Player (name);
      personalityTest();
      System.out.println("These are your stats:");
      _play.getStats();
      System.out.println("These are your dates:")
      //kevin1
      //kevin2
      //lauren
      System.out.println("Who would you like to date?");
      System.out.println("1: KXiao");
      System.out.println("2: KLi");
      System.out.println("3. LLee");

      chooseYourfighter();

      startDate(_story.getValue());

      play();
  }

/*
int _confidence;
int _intelligence;
int _kindness;
*/
  public void personalityTest(){
    System.out.println("Are you a human?");
    System.out.println("1. yes \n2.no");
    String response = _scanner.nextLine();
    while(!response.equals("1") || !reponse.equals("2")){
      System.out.println("That is not a valid option");
      response = _scanner.nextLine();
    }
    if (response.equals("1"){
      play.setIntelligence(play.getIntelligence()+10);
    } else (response.equals("2")){
      play.setConfidence(play.getConfidence()+10);
    }
    System.out.println("Do you like computer science?");
    System.out.println("1. yes \n2.no");
    response = _scanner.nextLine();
    while(!response.equals("1") || !reponse.equals("2")){
      System.out.println("That is not a valid option");
      response = _scanner.nextLine();
    }
    if (response.equals("1"){
      play.setKindness(play.getKindness()+10);
    } else (response.equals("2")){
      play.setIntelligence(play.getIntelligence()+10);
    }
    System.out.println("Would you steal an opportunity from another person even if you thought that opportunity would be way more useful for the other person?");
    System.out.println("1. yes \n2.no");
    response = _scanner.nextLine();
    while(!response.equals("1") || !reponse.equals("2")){
      System.out.println("That is not a valid option");
      response = _scanner.nextLine();
    }
    if (response.equals("1"){
      play.setConfidence(play.getConfidence()+10);
    } else (response.equals("2")){
      play.setKindness(play.getKindness()+10);
    }
  }

  public void chooseYourfighter() {
    String response = _scanner.nextLine();

    if (response.equals("1")) {
        _lover = new KXiao();
        _story = _lover.getStory();

        System.out.println("You have selected KXiao" + "\n");
      }

    // } else if(response.equals("2"){
    //     _lover = new KLi();
    //     _story = _lover.getStory();
    // } else if(response.equals("3")){
    //     _lover = new L
    // }
      else {
        System.out.println("that's not an option. Try again");
        chooseYourfighter();
    }
  }

  public void startDate(File date) {
      _lover.addLines(date);
  }

  public void endDate() {

  }

  //New in v2
  public void play() {
    Stack<String> dialogue = _lover.getDialogue();

    while (!dialogue.isEmpty()) {
        if (dialogue.peek().equals("prompt()")) {
            dialogue.pop();
            System.out.println("");
            _lover.sayLine();
            _lover.sayLine();
            _lover.sayLine();
            prompt();
        } else {
            _lover.sayLine();
        }
    }

  }

  //New in v2
  public void prompt() {
    String response = _scanner.nextLine();

    if (response.equals("1")) {
        _lover.moveLeft();
    } else if (response.equals("2")) {
        _lover.moveRight();
    } else {
        System.out.println("That is not a valid option");
        prompt();
    }

  }
}
