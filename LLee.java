
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
        _story.setleft(tennis);

        StoryNode rock = new StoryNode(_source + "rock/rock.txt");
        _story.setMind(rock);
    }

    public void receiveItem() {

    }

}
