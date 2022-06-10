
public class KXiao extends LoveInterest{

    public KXiao() {
        super("KXiao");
        _source = "KXiaoLines/";
        setStory();
    }

    public void setStory() {
        //root
        _story = new StoryNode(_source + "intro.txt");

        StoryNode cafe = new StoryNode(_source + "cafe/cafe.txt");
        _story.setLeft(cafe);

        StoryNode amusement = new StoryNode(_source + "amusement/amusement.txt");
        _story.setMid(amusement);

        StoryNode vb = new StoryNode(_source + "volleyball/volleyball.txt");
        _story.setRight(vb);
    }

    public void receiveItem() {

    }

}
