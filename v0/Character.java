package v1prototype;
import java.util.Stack;

public class Character{
  BST story;
  TreeNode currentNode;

  String name;
  int confidence;
  int intelligence;
  int kindness;

  Stack<String> dialogue;

  public Character(String name) {
      this.name = name;
      dialogue = new Stack<String>();
  }

  public void addDialogue(String line) {
      dialogue.push(line);
  }

  public int getConfidence() {
      return confidence;
  }

  public int getIntelligence() {
      return intelligence;
  }

  public int getKindness() {
      return kindness;
  }
  
}
