
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoveInterest {
    String _source;
    Stack<String> _dialogue;
    StoryNode _story;
    Scanner _fileReader;
    String _name;

    public LoveInterest(String name) {
        _dialogue = new Stack<>();
        _name = name;
    }

    public void addLine(String line) {
        _dialogue.push(line);
    }

    public void addLines(File lines) {
        try {
          _fileReader = new Scanner(lines);
      } catch (FileNotFoundException e) {
          System.out.println("Something went wrong in addLines(). Check that the file is named correctly and has the extension .txt");
          e.printStackTrace();
      }
        readBackwards();
    }
  
    public void readBackwards() {
      if (!_fileReader.hasNext()) {
          return;
      }
      String line = _fileReader.nextLine();
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
        //addLines(_story.getValue());
        return _story;
    }

    public StoryNode moveDown() {
        _story = _story.getMid();
        //addLines(_story.getValue());
        return _story;
    }

    public StoryNode moveRight() {
        _story = _story.getRight();
        //addLines(_story.getValue());
        return _story;
    }

    public String getName() {
        return _name;
    }

}
