
public class KLi extends LoveInterest{

    public KLi() {
        super("Kli");
        _source = "KLiLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(_source + "intro.txt");

        StoryNode rollerblading = new StoryNode(_source + "rollerblading/Rollerblading.txt");
        _story.setLeft(rollerblading);

        StoryNode gaming = new StoryNode(_source + "gaming/gaming.txt");
        _story.setMid(gaming);
    }

    public void receiveItem() {

    }

}
