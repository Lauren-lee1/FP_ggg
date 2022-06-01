import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Game{
  StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  
  public Game(){
      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("Who would you like to date?");
      System.out.println("1: KXiao");

      chooseYourfighter();

      startDate(_story.getValue());

      play();
  }

  public void chooseYourfighter() {
    String response = _scanner.nextLine();

    if (response.equals("1")) {
        _lover = new KXiao();
        _story = _lover.getStory();
        setStory(_lover);

        System.out.println("You have selected KXiao" + "\n");

    } else {
        System.out.println("that's not an option. Try again");
        chooseYourfighter();
    }
  }

  public void setStory(LoveInterest lover) {
      _story = lover.getStory();
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
            System.out.println("\n");
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

    Scanner reader = new Scanner(System.in);
    String response = reader.nextLine();

    if (response.equals("1")) {
        _lover.moveLeft();
        play();
    } else if (response.equals("2")) {
        _lover.moveRight();
        play();
    } else {
        System.out.println("That is not a valid option");
        prompt();
    }
    
  }   
}
