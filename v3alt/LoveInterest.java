package v3alt;

import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoveInterest extends Character{

    Stack<String> _dialogue;
    StoryNode _story;
    Scanner fileReader;

    public LoveInterest(String name) {
        super(name);
        _dialogue = new Stack<>();
    }

    public void addLine(String line) {
        if (line.indexOf("|") == -1) {
            _dialogue.push(line);
        }
    }
  
    public void addLines() {
        try {
            fileReader = new Scanner(_story.getValue());
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong in addLines()");
            e.printStackTrace();
        }
          readBackwards();
    }

    public void addLines(File lines) {
        try {
          fileReader = new Scanner(lines);
      } catch (FileNotFoundException e) {
          System.out.println("Something went wrong in addLines(File lines)");
          e.printStackTrace();
      }
        readBackwards();
    }
  
    public void readBackwards() {
      if (!fileReader.hasNextLine()) {
          return;
      }
      String line = fileReader.nextLine();
      readBackwards();
      addLine(line);
    }

    public void receiveItem() {
        System.out.println("thanks for the gift");
    }

    public Stack<String> getDialogue() {
        return _dialogue;
    }

    public void moveLeft() {
        _story = _story.getLeft();
        addLines();
    }

    public void moveDown() {
        _story = _story.getMid();
        addLines();
    }

    public void moveRight() {
        _story = _story.getRight();
        addLines();
    }

}
