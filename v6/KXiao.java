package v6;
public class KXiao extends LoveInterest{

    public KXiao() {
        super("KXiao");
        source = "v6/KXiaoLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(source + "intro.txt");

        StoryNode cafe = new StoryNode(source + "cafe/cafe.txt");
        _story.setLeft(cafe);

        StoryNode amusement = new StoryNode(source + "amusement.txt");
        _story.setMid(amusement);

        StoryNode vb = new StoryNode(source + "volleyball.txt");
        _story.setRight(vb);
    }

    public void receiveItem() {

    }

}
