package v7;
public class LLee extends LoveInterest{

    public LLee() {
        super("LLee");
        source = "v7/LLeeLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(source + "intro.txt");
    }

    public void receiveItem() {

    }

}
