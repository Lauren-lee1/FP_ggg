package v3alt;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {
  //StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  Stack<String> _dialogue;
  Player _player;

  public Game(){
      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("What is your name?");
      String name = _scanner.nextLine();
      _player = new Player(name);

      //personalityTest();
      System.out.println("These are your stats:");
      _player.getStats();
      System.out.println("These are your dates:");
      //kevin1
      //kevin2
      //lauren
      System.out.println("Who would you like to date?");
      System.out.println("1: KXiao");
      System.out.println("2: KLi");
      System.out.println("3. LLee");

      chooseYourfighter();

      play();
  }

  public void chooseYourfighter() {
    String response = _scanner.nextLine();

    if (response.equals("1")) {
        _lover = new KXiao();
        _dialogue = _lover.getDialogue();

        System.out.print("You have selected KXiao" + "\n");

    } else {
        System.out.println("that's not an option. Try again");
        chooseYourfighter();
    }
  }

  public void endDate() {

  }

  //New in v2
  public void play() {
    _lover.addLines();

    while (!_dialogue.isEmpty()) {
        if (_dialogue.peek().equals("prompt()")) {
            _dialogue.pop();
            prompt();
        } else if (_dialogue.peek().equals("end()")) {
            break;
        } else {
            System.out.println(_dialogue.pop());
        }
    }

  }

  //New in v3
  public void prompt() {
    System.out.print("\n");
    ArrayList<String> effects;

    //print the question
    System.out.println(_dialogue.pop());

    //print all options and store them
    effects = printOptions();

    //get a player response
    int response = -1;
    while (true) {
        try {
            response = Integer.parseInt(_scanner.nextLine());
            if (response > 0 && response <= effects.size()) {
                break;
            }
        } catch (Exception e) {
            //System.out.println("That's not a valid response");
        }
        System.out.println("That's not a valid response");
    }

    //get the option corresponding to the response
    String choice = effects.get(response - 1);
    //System.out.println("you chose " + choice);

    //run the action corresponding to the option
    actionSelect(choice);
  }   

  public ArrayList<String> printOptions() {
    String nextLine;
    ArrayList<String> effects = new ArrayList<String>();

    while(!_dialogue.empty()) {
        nextLine = _dialogue.peek();

        if (nextLine.indexOf(":") != -1) {
            effects.add(nextLine);
            if (nextLine.indexOf("/") != -1) {
                nextLine = nextLine.substring(0, nextLine.indexOf("/"));
            }
            System.out.println(nextLine);
        } else break;

        _dialogue.pop();
    }

    return effects;
  }

  //new in v3
  public void actionSelect(String input) {
    //System.out.println("Entered action select");
    int indexOfSlash = input.indexOf("/");
    //if there is no extra action
    if (indexOfSlash == -1) {
        //System.out.println("no slash detected");
        return;
    }

    String choice = input.substring(indexOfSlash + 1).toLowerCase();
    String[] actions = choice.split(";");
    for (String a : actions) {
        //System.out.println("detected the action " + a);
    }

    for (String a : actions) {
        //System.out.println("loop entered");
        String action = a.trim();
        int indexOfSpace = action.indexOf(" ");

        //System.out.println(action);

        if (action.substring(0, 1).equals("+") || action.substring(0, 1).equals("-")) {
            //System.out.println("Stat change detected");
            changeStats(action);
        }

        if (action.equals("left()")) {
            _lover.moveLeft();
        }

        if (action.equals("mid()")) {
            _lover.moveDown();
        }

        if (action.equals("right()")) {
            _lover.moveRight();;
        }

        if (action.equals("anObject")) {
            
        }
    }
  }

  public void changeStats(String input) {
    int indexOfSpace = input.indexOf(" ");

    String operation = input.substring(0, 1);
    int amountIncreased = Integer.parseInt(input.substring(0, indexOfSpace));
    String statChanged = input.substring(indexOfSpace + 1);
  
    if (operation.equals("-")) {
        amountIncreased = 0 - amountIncreased;
    }
    if (statChanged.equals("confidence")) {
        _player.setConfidence(_player.getConfidence() + amountIncreased);
        System.out.println("confidence increased");
    }
    if (statChanged.equals("intelligence")) {
        _player.setConfidence(_player.getIntelligence() + amountIncreased);
        System.out.println("intelligence increased");
    }
    if (statChanged.equals("kindness")) {
        _player.setConfidence(_player.getKindness() + amountIncreased);
        System.out.println("kindness increased");
    }
  }
}
