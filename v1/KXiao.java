public class KXiao extends LoveInterest{
    String source = "KXiaoLines/";

    public KXiao() {
        super("KXiao");
        setStory();
    }

    public void setStory() {
        _story = new StoryNode(source + "a1.txt");

    }
    
    public void receiveItem() {
        
    }
}
