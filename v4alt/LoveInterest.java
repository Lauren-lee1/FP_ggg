package v4alt;

import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoveInterest extends Character{
    public String source;
    Stack<String> _dialogue;
    StoryNode _story;
    Scanner fileReader;

    public LoveInterest(String name) {
        super(name);
        _dialogue = new Stack<>();
    }

    public void addLine(String line) {
        _dialogue.push(line);
    }

    public void addLines(File lines) {
        try {
          fileReader = new Scanner(lines);
          //fileReader.useDelimiter("\n");
      } catch (FileNotFoundException e) {
          System.out.println("Something went wrong in addLines(). Check that the file is named correctly and has the extension .txt");
          e.printStackTrace();
      }
        readBackwards();
    }
  
    public void readBackwards() {
      if (!fileReader.hasNext()) {
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

    public StoryNode getStory() {
        return _story;
    }

    public void setStory(StoryNode story) {
        _story = story;
    }

    public StoryNode moveLeft() {
        _story = _story.getLeft();
        addLines(_story.getValue());
        return _story;
    }

    public StoryNode moveDown() {
        _story = _story.getMid();
        addLines(_story.getValue());
        return _story;
    }

    public StoryNode moveRight() {
        _story = _story.getRight();
        addLines(_story.getValue());
        return _story;
    }

}
