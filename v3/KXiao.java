public class KXiao extends LoveInterest{
    String source = "KXiaoLines/";

    public KXiao() {
        super("KXiao");
        setStory();
    }

    public void setStory() {
        _story = new StoryNode(source + "a1.txt");
        StoryNode b1 = new StoryNode(source + "b1.txt");
        StoryNode b2 = new StoryNode(source + "b2.txt");

        _story.setLeft(b1);
        _story.setRight(b2);
    }

    public void receiveItem() {
        
    }
}
