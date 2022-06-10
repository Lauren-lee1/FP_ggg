
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {
  StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  Stack<String> _dialogue;
  Player _player;
  ArrayList<StoryNode> _playerPath;
  ArrayList<LoveInterest> _listOfLovers;
  Stack<LoveInterest> _StackOfMen;

  public Game(){
      _listOfLovers = new ArrayList<>();
      _listOfLovers.add(new KXiao());
      _listOfLovers.add(new KLi());
      _listOfLovers.add(new LLee());

      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("What is your name?");
      String name = _scanner.nextLine();
      _player = new Player(name);
      _StackOfMen = new Stack<>();
      //playSecretEnding();

      personalityTest();
  }

  public void personalityTest(){

    if (_listOfLovers.size() == 0) {
        if (_StackOfMen.size() == 0) {
            playSecretEnding();
        } else {
            System.out.println("You have dated all the characters");
            System.out.println("Congratulations, the game is finished");
            System.exit(0);
        }
    }

    System.out.println("=======Personality Test=======");
    wait(750);
    System.out.println("Are you a human?");
    if (yes()) {
      _player.setIntelligence(_player.getIntelligence()+10);
    } else {
      _player.setConfidence(_player.getConfidence()+10);
    }

    wait(750);
    System.out.println("Do you like computer science?");
    if (yes()) {
      _player.setKindness(_player.getKindness()+10);
    } else {
      _player.setIntelligence(_player.getIntelligence()+10);
    }

    wait(750);
    System.out.println("Would you steal an opportunity from another person even if you thought that opportunity would be way more useful for the other person?");
    if (yes()){
      _player.setConfidence(_player.getConfidence()+10);
    } else {
      _player.setKindness(_player.getKindness()+10);
    }

    wait(750);
    System.out.println("These are your stats:");
    _player.printStats();
    System.out.print("\n");
    chooseYourfighter();
  }

  public boolean yes() {
    System.out.println("1. yes \n2. no");
    String response = _scanner.nextLine();

    while(!response.equals("1") && !response.equals("2")){
      System.out.println("That is not a valid option");
      response = _scanner.nextLine();
    }

    if (response.equals("1")) {
        return true;
    }
    return false;
  }

  public void chooseYourfighter() {

    System.out.println("=======Choose Your Fighter=======");
    System.out.println("These are your dates:");
    int counter = 0;
    for (LoveInterest lover : _listOfLovers) {
        counter++;
        System.out.println(counter + ": " + lover.getName());
    }
    System.out.println("Who would you like to date?");

    while (true) {
        try {
            int response = Integer.parseInt(_scanner.nextLine());

            if (response > 0 && response <= _listOfLovers.size()) {
                _lover = _listOfLovers.get(response - 1);
                _lover.setup();
                _story = _lover.getStory();
                _dialogue = _lover.getDialogue();
                _playerPath = new ArrayList<StoryNode>();
                _playerPath.add(_story);

                System.out.println("You have selected " + _lover.getName());
                System.out.println("=======================");
                _lover.printBlurb();
                break;
            }
        } catch (Exception e) {
            System.out.println("that's not an option. Try again");
            //System.out.println(e);
        }
    }
    play();
  }

  public void play() {
    _lover.addLines(_story.getValue());

    while (!_dialogue.isEmpty()) {
        String currLine = _dialogue.peek().trim();

        wait(750);
        if (currLine.equals("prompt()")) {
            _dialogue.pop();
            prompt();
        } else {
            System.out.println(_dialogue.pop());
        }
    }

    menu();
  }

  public void menu() {

      wait(750);
      int numberOfOptions = _story.getNumberOfChildren();
      int response = -1;

      if (numberOfOptions == 0) {
          replay();
          numberOfOptions = _story.getNumberOfChildren();
      } else {

      System.out.println("===================MENU====================");
      System.out.println("you have completed the date: " + _story + "\n");
      System.out.println("What kind of date would you like to go on?");
      System.out.println("0: I'd like to see my stats");

      if (numberOfOptions >= 1) {
        System.out.println("1: " + _story.getLeft());
      }
      if (numberOfOptions >= 2) {
        System.out.println("2: " + _story.getMid());
      }
      if (numberOfOptions >= 3) {
        System.out.println("3: " + _story.getRight());
      }

      response = -1;
      while (true) {
          try {
              response = Integer.parseInt(_scanner.nextLine());
              if (response > 0 && response <= numberOfOptions) {
                  break;
              }
          } catch (Exception e) {}

          if (response == 0) {
              _player.printStats();
          } else {
              System.out.println("That's not a valid response");
          }
      }

      if (response == 1) {
        _story = _lover.moveLeft();
      }
      if (response == 2) {
        _story = _lover.moveDown();
      }
      if (response == 3) {
        _story = _lover.moveRight();
      }

    }
      if (_playerPath.indexOf(_story) == -1) {
        _playerPath.add(_story);
      }
      play();
  }

  public void replay() {
    wait(750);
    System.out.println("You have reached the end of this story");
    System.out.println("Do you want to keep dating this person?");
    if (!yes()) {
        System.out.println(_lover.getName() + " has been deleted from this plane of existence");
        System.out.println("Now returning to the personality test (you can farm up stats)");
        _listOfLovers.remove(_lover);
        personalityTest();
    }
    System.out.println("Enter the index of the date you'd like to return to");
    System.out.println(_playerPath);

    while (true) {
        try {
            int response = Integer.parseInt(_scanner.nextLine());
            _lover.setStory(_playerPath.get(response));
            _story = _lover.getStory();
            _dialogue = _lover.getDialogue();

            while (response < _playerPath.size()) {
                _playerPath.remove(response);
            }
            break;
        } catch (Exception e) {
            System.out.println("That's not a valid response");
        }
    }
  }

  public void prompt() {
    wait(750);
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
                String choice = effects.get(response - 1);
                if (actionSelect(choice)) {
                    break;
                }
            } else {
                System.out.println("That's not a valid response");
            }
        } catch (Exception e) {
            System.out.println("That's not a valid response");
            //e.printStackTrace();
        }

    }

    System.out.println(" ");
  }

  public ArrayList<String> printOptions() {
    String nextLine;
    ArrayList<String> effects = new ArrayList<String>();
    Integer counter = 1;

    while(!_dialogue.empty()) {
        nextLine = _dialogue.peek();

        if (nextLine.length() > 0 && nextLine.substring(0,1).equals(counter.toString())) {
            effects.add(nextLine);
            if (nextLine.indexOf("/") != -1) {
                nextLine = nextLine.substring(0, nextLine.indexOf("/"));
            }
            if (nextLine.indexOf("<name>") != -1) {
                int indexOfName = nextLine.indexOf("<name>");
                String temp = nextLine.substring(indexOfName + 6);
                nextLine = nextLine.substring(0, indexOfName);
                nextLine += _player.getName();
                nextLine += temp;
            }

            System.out.println(nextLine);
            counter++;
        } else break;

        _dialogue.pop();
    }

    return effects;
  }

  public boolean actionSelect(String input) {
    int indexOfSlash = input.indexOf("/");

    //if there is no slash, there is no action, so just return and do nothing to avoid complications with everything else
    if (indexOfSlash == -1) {
        return true;
    }

    //choice is a string of everything after the /
    String choice = input.substring(indexOfSlash + 1);
    //actions is an array of all the actions. A single option can play multiple options. Actions are separated with a ;
    String[] actions = choice.split(";");

    for (String a : actions) {
        //trim all the strings so we don't encounter problems with leading or trailing spaces
        String action = a.trim().toLowerCase();

        //detects and applies a stat change action
        //ex: +10 Kindness
        if (action.substring(0, 1).equals("+") || action.substring(0, 1).equals("-")) {
            changeStats(action);
        }

        if (action.equals("return()")) {
            System.out.println("now returning to character select" + "\n");
            _dialogue.clear();
            chooseYourfighter();
        }

        if (action.equals("capture()")) {
            _listOfLovers.remove(_lover);
            _StackOfMen.add(_lover);
            System.out.println("You have captured " + _lover.getName() + " in your stack");
            System.out.println("Now returning to the personality test (you can farm up stats)");
            personalityTest();
            chooseYourfighter();
        }

        //syntax: >5 intelligence
        if (action.indexOf(">") != -1){
          int indexOfSpace = action.indexOf(" ");
          int amount = Integer.parseInt(action.substring(1, indexOfSpace));
          String stat = action.substring(indexOfSpace + 1);
          boolean canChoose = false;

          if (stat.equals("confidence")) {
              canChoose = (_player.getConfidence() > amount);
              stat = _player.getConfidence() + " " + stat;
          }
          if (stat.equals("intelligence")) {
              canChoose = (_player.getIntelligence() > amount);
              stat = _player.getIntelligence() + " " + stat;
          }
          if (stat.equals("kindness")) {
              canChoose = (_player.getKindness() > amount);
              stat = _player.getKindness() + " " + stat;
          }

          if (!canChoose) {
              System.out.println("Your " + stat + " isn't high enough to pick this option");
              return canChoose;
          }

        }

        if (action.indexOf("load") != -1) {
            //if the current txt file is KXiaoLines/cafe/cafe.txt
            //First you get the path: KXiaoLines/cafe/cafe.txt
            String path = _story._path;

            //then you remove the part after the last slash
            //basically, we want to go up one level in the folders
            //this code will change path to: KXiaoLines/cafe
            for (int i = path.length() - 1; i >=0; i--) {
                if(path.substring(i, i + 1).equals("/")) {
                    path = path.substring(0, i);
                    break;
                }
            }

            //then we take that path and add a slash: KXiaoLines/cafe/
            path += "/";

            //then add on the name of the file specified by this action
            //ex: KXiaoLines/cafe/cafe_tea.txt
            path += action.substring(5, action.length() - 1);

            //then you locate the file with that path
            File file = new File(path);
            //and add the lines in that file into the dialogue
            _lover.addLines(file);
        }

        //ends the current date
        if (action.equals("end()")) {
            _dialogue.clear();
        }

        //this is for if you want to print small enough that it doesn't warrant a separate file
        if (action.indexOf("print") != -1) {
            //We want to printed message to preserve capitalization
            //the trim here is because we are working with a, which is untrimmed, and not lowercase
            System.out.println(a.trim().substring(6, action.length()-1));
        }
    }
    return true;
  }

  public void changeStats(String input) {
    int indexOfSpace = input.indexOf(" ");
    int amountIncreased = Integer.parseInt(input.substring(0, indexOfSpace));
    String statChanged = input.substring(indexOfSpace + 1);

    if (statChanged.equals("confidence")) {
        _player.setConfidence(_player.getConfidence() + amountIncreased);
    }
    if (statChanged.equals("intelligence")) {
        _player.setIntelligence(_player.getIntelligence() + amountIncreased);
    }
    if (statChanged.equals("kindness")) {
        _player.setKindness(_player.getKindness() + amountIncreased);
    }
    System.out.println(input);
  }

  private static void wait(int millis) {
    try {
      Thread.sleep(millis);
    	}
    catch (InterruptedException e) {
    	}
    }

  public void playSecretEnding() {
      File file = new File("SecretEndingDoNotLook.txt");
      Scanner scanner;
      System.out.println("============???============");
    try {
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.indexOf("<name>") != -1) {
                System.out.println(_player.getName() + nextLine.substring(6));
            } else {
                System.out.println(nextLine);
            }
            wait(1500);
        }
        System.exit(0);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  }
}
