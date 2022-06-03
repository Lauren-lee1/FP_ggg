package v4alt;
import java.io.File;
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

  public Game(){
      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("What is your name?");
      String name = _scanner.nextLine();
      _player = new Player(name);
      _playerPath = new ArrayList<StoryNode>();

      //personalityTest();
      System.out.println("These are your stats:");
      _player.printStats();
      System.out.println("These are your dates:");

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
        _story = _lover.getStory();
        _dialogue = _lover.getDialogue();

        System.out.print("You have selected KXiao" + "\n");

    } else {
        System.out.println("that's not an option. Try again");
        chooseYourfighter();
    }
  }

  //v4alt: augmented to be able to end the game
  public void play() {
    _lover.addLines(_story.getValue());

    while (!_dialogue.isEmpty()) {
        if (_dialogue.peek().equals("end()")) {
            _dialogue.clear();
        } else 
        if (_dialogue.peek().trim().equals("prompt()")) {
            _dialogue.pop();
            prompt();
        } else {
            System.out.println(_dialogue.pop());
        }
    }

    menu();

  }

  //v4alt: menu for selecting how you want to move down the story tree, and for replaying
  //you will enter the menu after finishing a date
  //dates finish when there is no more dialogue to be said. This could be because the story runs to its end, or a bad decision caused an early end
  public void menu() {
      //getNumberOfChildren() is a new method that just returns how many children a node has
      int numberOfOptions = _story.getNumberOfChildren();
      int response = -1;

      //if the node you are on has no children, then you can't progress the story any further
      if (numberOfOptions == 0) {
          //give the player the option to revisit any nodes they went to on the way to this ending
          System.out.print("\n");
          System.out.println("You have reached the end of this story");
          System.out.println("Enter a number between " + 1 + " and " + _playerPath.size() + " (both inclusive) to return to a previous point");

          //_playerpath is an arraylist that stores all the nodes you've been to
          //nodes are added to this list after the player has reached an ending in that node
          System.out.println(_playerPath);

          //after picking a node to go back to, remove that node and all nodes after
          //ex: if the order of nodes I went to was: [intro, cafe, apocalypse] and I choose to return to cafe, _playerPath becomes [intro]
          //if you return to cafe, you return the point after you completed cafe, so cafe is added back into the arraylist
          while (true) {
            try {
                response = Integer.parseInt(_scanner.nextLine());
                _lover.setStory(_playerPath.get(response - 1));
                _story = _lover.getStory();

                while (response - 1 < _playerPath.size()) {
                    _playerPath.remove(response - 1);
                }
                break;
            } catch (Exception e) {
                System.out.println("That's not a valid response");
            }
          }
          numberOfOptions = _story.getNumberOfChildren();
      } 

      //options in the menu
      System.out.println("===================MENU====================");
      _playerPath.add(_story);
      System.out.println("you have completed the date: " + _story + "\n");
      System.out.println("What kind of date would you like to go on?"); 
      System.out.println("0: I'd like to see my stats");

      //prints the names of the different date options. will only print as many options as the current node has children
      if (numberOfOptions >= 1) {
        System.out.println("1: " + _story.getLeft());
      }
      if (numberOfOptions >= 2) {
        System.out.println("2: " + _story.getMid());
      }
      if (numberOfOptions >= 3) {
        System.out.println("3: " + _story.getRight());
      }

      //this is for the player to select which date to go on, and therefore which node to move to
      response = -1;
      while (true) {
          try {
              response = Integer.parseInt(_scanner.nextLine());
              if (response > 0 && response <= numberOfOptions) {
                  break;
              }
          } catch (Exception e) {
              //System.out.println("That's not a valid response");
          }
          if (response == 0) {
              _player.printStats();
          } else System.out.println("That's not a valid response");
      }

      //this loads mroe dialogue into _story
      if (response == 1) {
        _story = _lover.moveLeft();
      }
      if (response == 2) {
        _story = _lover.moveDown();
      }
      if (response == 3) {
        _story = _lover.moveRight();
      }

      //and now that there's dialogue again, play() can loop
      //basically menu() is a big refueling station
      play();
  }

  public void prompt() {
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
    System.out.println(" ");
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

  //v4alt: a general method for detecting actions written into the txt files
  public void actionSelect(String input) {
    //adding a slash after an option in a prompt will play an action when that option is chosen
    int indexOfSlash = input.indexOf("/");

    //if there is no slash, there is no action, so just return and do nothing
    if (indexOfSlash == -1) {
        return;
    }

    //choice is a string of everything after the /
    String choice = input.substring(indexOfSlash + 1).toLowerCase();
    //actions is an array of all the actions. A single option can play multiple options. Actions are separated with a ;
    String[] actions = choice.split(";");

    for (String a : actions) {
        //trim all the strings so we don't encounter problems with leading or trailing spaces
        String action = a.trim();

        //detects and applies a stat change action
        //ex: +10 Kindness
        if (action.substring(0, 1).equals("+") || action.substring(0, 1).equals("-")) {
            changeStats(action);
        }

        //detects and applies a load dialogue action
        //ex: load(cafe_tea.txt)
        if (action.indexOf("load") != -1) {
            //if the current txt file is KXiaoLines/cafe/cafe.txt
            //First you get the path: KXiaoLines/cafe/cafe.txt
            String path = _story.path;

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
            //play() runs while there is dialogue to be popped, so clearing the dialogue stops the loop
            _dialogue.clear();
        }

        //this is for if you want to print small enough that it doesn't warrant a separate file
        //ex: print() hello
        //yes the syntax is weird. This was made with a purpose that I ultimately abandoned so I just left it
        if (action.indexOf("print()") != -1) {
            System.out.println(action.substring(8));
        }

        if (action.equals("left()")) {
            _lover.moveLeft();
        }

        if (action.equals("mid()")) {
            _lover.moveDown();
        }

        if (action.equals("right()")) {
            _lover.moveRight();
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
        System.out.println(input);
    }
    if (statChanged.equals("intelligence")) {
        _player.setConfidence(_player.getIntelligence() + amountIncreased);
        System.out.println(input);
    }
    if (statChanged.equals("kindness")) {
        _player.setConfidence(_player.getKindness() + amountIncreased);
        System.out.println(input);
    }
  }
}
