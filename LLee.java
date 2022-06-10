
public class LLee extends LoveInterest{

    public LLee() {
        super("LLee");
        _source = "LLeeLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(_source + "intro.txt");
        StoryNode tennis = new StoryNode(_source + "tennis/tennis.txt");
        _story.setLeft(tennis);

        StoryNode rock = new StoryNode(_source + "rock/rock.txt");
        _story.setMid(rock);
    }

    public void printBlurb() {
        String output = "";
        output += "Confidence, kindness, and intelligence, for Kevin Laur you have to have it all. Extremely competitive and confident in sports, it" + "\n";
        output += "will take immense talent for you to one-up them. Show your confidence, kindness, and intelligence and conquer this Kevin!" + "\n";
        System.out.println(output);
    }

}
