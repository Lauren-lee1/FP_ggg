import java.util.Stack;
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

        StoryNode cafe = new StoryNode("cafe.txt")
        _story.setLeft(cafe);
        cafe.setRight(_story); //bad
        StoryNode cafeGood = new StoryNode("cafeGood.txt")
        cafe.setLeft(cafeGood) //good

        StoryNode amusement = new StoryNode("amusement.txt")
        _story.setMid(amusement);
        amusement.setRight(_story); //bad
        StoryNode amusementGood = new StoryNode("amusementGood.txt")
        amusement.setLeft(amusementGood) //good

        StoryNode vb = new StoryNode("volleyball .txt")
        _story.setRight(vb);
        vb.setRight(_story); //bad
        StoryNode vbGood = new StoryNode("vbGood.txt")
        vb.setLeft(vbGood) //good
    }

    public void play(StoryNode node) {
      Stack<String> dialogue = new Stack<String>
      dialogue = addLines(node.getValue())
      while (!dialogue.isEmpty()) {
          if (dialogue.peek().equals("prompt()")) {
              dialogue.pop();
              prompt();
          } else {
              _lover.sayLine();
          }
      }

      public void addLine(Stack<String> fileDialogue, String line) {
          fileDialogue.push(line);
      }

      public Stack<String> addLines(File lines) {
        Stack<String> dialogue = new Stack<String>;
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

    public void receiveItem() {

    }
}
