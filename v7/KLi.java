package v7;
public class KLi extends LoveInterest{

    public KLi() {
        super("Kli");
        source = "v7/KLiLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(source + "intro.txt");

        StoryNode rollerblading = new StoryNode(source + "Rollerblading/Rollerblading.txt");
        _story.setLeft(rollerblading);
    }

    public void receiveItem() {

    }

}
