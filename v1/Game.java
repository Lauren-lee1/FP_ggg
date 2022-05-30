import java.io.File;
import java.util.Scanner;

public class Game{
  StoryNode _story;
  LoveInterest _lover;
  Scanner _scanner = new Scanner(System.in);
  
  public Game(){
      System.out.println("Welcome to Lauren's Kevin Harem");
      System.out.println("Who would you like to date?");
      System.out.println("1: KXiao");

      chooseYourfighter();

      startDate(_story.getValue());
      _lover.sayLine();
      _lover.sayLine();
  }

  public void chooseYourfighter() {
    String response = _scanner.nextLine();

    if (response.equals("1")) {
        _lover = new KXiao();
        _story = _lover.getStory();
        setStory(_lover);

        System.out.println("You have selected KXiao" + "\n");

    } else {
        System.out.println("that's not an option. Try again");
        chooseYourfighter();
    }
  }

  public void setStory(LoveInterest lover) {
      _story = lover.getStory();
  }

  public void startDate(File date) {
      _lover.addLines(date);
  }

  public void endDate() {

  }

  
}
