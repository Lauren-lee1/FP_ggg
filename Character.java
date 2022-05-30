import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Character{

  String _name;
  int _confidence;
  int _intelligence;
  int _kindness;

  Stack<String> _dialogue;
  Scanner fileReader;

  public Character(String name) {
      _name = name;
      _dialogue = new Stack<String>();
  }

  public void addLine(String line) {
      _dialogue.push(line);
  }

  public void addLines(File lines) {
      try {
        fileReader = new Scanner(lines);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
      readBackwards();
  }

  public void readBackwards() {
    String line = "";
    while (fileReader.hasNext()) {
        line = fileReader.nextLine();
        readBackwards();
    }
    addLine(line);
  }

  public void sayLine() {
      System.out.println(_dialogue.pop());
  }

  public int getConfidence() {
      return _confidence;
  }

  public int getIntelligence() {
      return _intelligence;
  }

  public int getKindness() {
      return _kindness;
  }

  public String getName() {
      return _name;
  }

  public void setConfidence(int confidence) {
      _confidence = confidence;
  }

  public void setIntelligence(int intelligence) {
      _intelligence = intelligence;
  }

  public void setKindness(int kindness) {
      _kindness = kindness;
  }

  
}
