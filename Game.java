import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game{
  StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  Stack<String> _dialogue;
  Player _player = new Player("name");
  
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
        _dialogue = _lover.getDialogue();

        System.out.println("You have selected KXiao" + "\n");

    } else {
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

    while (!_dialogue.isEmpty()) {
        if (_dialogue.peek().equals("prompt()")) {
            _dialogue.pop();
            prompt();
        } else {
            _lover.sayLine();
        }
    }
      
  }

  //New in v3
  public void prompt() {
    System.out.print("\n");
    ArrayList<String> effects = new ArrayList<String>();

    //print the question
    _lover.sayLine(); 
    
    //print all options
    while (!_dialogue.empty()) {
        String nextLine = _dialogue.peek();
        if (nextLine.indexOf(":") != -1) {
            int indexOfSlash = nextLine.indexOf("/");
            String option = nextLine.substring(0, indexOfSlash);
            String effect = nextLine.substring(indexOfSlash + 1);

            System.out.println(option);

            effects.add(effect);
            _dialogue.pop();
        } else {
            break;
        }
    }

    int response = -1;
    while (true) {
        try {
            response = Integer.parseInt(_scanner.nextLine());

            if (response > 0 && response <= effects.size()) {
                decision(effects, response);
                break;
            }

        } catch (Exception e) {
            System.out.println("That's not a valid response");
        }
    }
  }

  //new in v3
  public void decision(ArrayList<String> effects, int response) {
      String appliedEffect = effects.get(response - 1).trim();

      int indexOfSpace = appliedEffect.indexOf(" ");

      String operation = appliedEffect.substring(0, 1);
      int amountIncreased = Integer.parseInt(appliedEffect.substring(0, indexOfSpace));
      String statChanged = appliedEffect.substring(indexOfSpace).toLowerCase();
      
      if (operation.equals("-")) {
          amountIncreased = 0 - amountIncreased;
      }

      if (statChanged.equals("confidence")) {
          _player.setConfidence(_player.getConfidence() + amountIncreased);
      } 
      if (statChanged.equals("intelligence")) {
        _player.setConfidence(_player.getIntelligence() + amountIncreased);
      }
      if (statChanged.equals("kindness")) {
        _player.setConfidence(_player.getKindness() + amountIncreased);
      }

      System.out.println(appliedEffect);
  }
}
