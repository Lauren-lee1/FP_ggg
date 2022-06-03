import java.util.Stack;
import java.util.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class KXiao extends LoveInterest{
    String source = "KXiaoLines/";
    Stack<String> _dialogue;

    public KXiao() {
        super("KXiao");
        setStory();
    }

    // public void setDialogue(){
    //   _dialogue = new Stack<String>;
    //   addLines(all.txt);
    // }

    public void setStory() {
        //root
        _story = new StoryNode(source + "intro.txt");

        StoryNode cafe = new StoryNode("cafe.txt");
        _story.setLeft(cafe);
        cafe.setRight(_story); //bad
        StoryNode cafeGood = new StoryNode("cafeGood.txt");
        cafe.setLeft(cafeGood); //good

        StoryNode amusement = new StoryNode("amusement.txt");
        _story.setMid(amusement);
        amusement.setRight(_story); //bad
        StoryNode amusementGood = new StoryNode("amusementGood.txt");
        amusement.setLeft(amusementGood); //good

        StoryNode vb = new StoryNode("volleyball .txt");
        _story.setRight(vb);
        vb.setRight(_story); //bad
        StoryNode vbGood = new StoryNode("vbGood.txt");
        vb.setLeft(vbGood); //good
    }


dialogue.
    public void play(StoryNode node) {
      _dialogue = new Stack<String>();
      _dialogue = addLines(node.getValue());
      String currDialogue = _dialogue.peek();
      while (!_dialogue.isEmpty()) {
        if(currDialogue.indexOf("|") != -1 ){
          currDialogue = currDialogue.trim();
          currDialogue = currDialogue.substring(1);
          currDialogue = currDialogue.trim();

        }
          if (currDialogue.equals("prompt()")) {
            _dialogue.pop();
            prompt();
          } else if (currDialogue.equals("traverse()")){
            _dialogue.pop();
            traverse();
          }
            else {
            System.out.println(_dialogue.pop());
          }
        }
      }

      public void play() {
        String dialogue = _dialogue.peek();
        while (!_dialogue.isEmpty()) {
          if(dialogue.indexOf("|") != -1 ){
            dialogue = dialogue.trim();
            dialogue = dialogue.substring(1);
            dialogue = dialogue.trim();

          }
            if (dialogue.equals("prompt()")) {
              _dialogue.pop();
              prompt();
            } else if (dialogue.equals("traverse()")){
              _dialogue.pop();
              traverse();
            }
              else {
              System.out.println(_dialogue.pop());
            }
        }

      }

      public void addLine(Stack<String> fileDialogue, String line) {
          fileDialogue.push(line);
      }

      public Stack<String> addLines(File lines) {
        Stack<String> dialogue = new Stack<String>();
          try {
            fileReader = new Scanner(lines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
          readBackwards(dialogue);
          return dialogue;
      }

      //bug fix in v2: was previously printing "" when the file reader had no next line
      public void readBackwards(Stack<String> fileDialogue) {
        if (!fileReader.hasNextLine()) {
            return;
        }
        String line = fileReader.nextLine();
        readBackwards(fileDialogue);
        addLine(fileDialogue,line);
      }
    //
    // public void traverseStory(){
    //
    // }

    public void traverse(){
      System.out.print("\n");
      ArrayList<String> effects = new ArrayList<String>();

      //print the question
      System.out.println(_dialogue.pop());

      //print all options
      while (!_dialogue.empty()) {
          int counter = 0;
          String nextLine = _dialogue.peek();
          if (nextLine.indexOf(":") != -1) {
              System.out.println(_dialogue.pop());
              counter ++;
          } else {
              break;
          }
          if(counter == 0){
            _story = _story.getRight();
            play(_story); //might cause bugs
          } else{
            String response = "d";
            while (true) {
                try {
                  if(response.equals("a")){
                    _story = _story.getLeft();
                    play(_story);
                  } else if (response.equals("b")){
                    _story = _story.getRight();
                    play(_story);
                  } else{
                    _story = _story.getMid();
                    play(_story);
                  }

                } catch (Exception e) {
                    System.out.println("That's not a valid response");
                }
            }
          }
      }

    }
    /*
    public void receiveItem() {

    }
    */
}
