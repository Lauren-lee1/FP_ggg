package v3alt;
public class KXiao extends LoveInterest{
    String source = "v3alt/KXiaoLines/";

    public KXiao() {
        super("KXiao");
        setStory();
    }

    // public void setDialogue(){
    //   _dialogue = new Stack<String>;
    //   addLines(all.txt);
    // }

    public void setStory() {
        //root
        _story = new StoryNode(source + "intro.txt");

        StoryNode cafe = new StoryNode(source + "cafe.txt");
        _story.setLeft(cafe);
        cafe.setRight(_story); //bad
        StoryNode cafeGood = new StoryNode("cafeGood.txt");
        cafe.setLeft(cafeGood); //good

        StoryNode amusement = new StoryNode("amusement.txt");
        _story.setMid(amusement);
        amusement.setRight(_story); //bad
        StoryNode amusementGood = new StoryNode("amusementGood.txt");
        amusement.setLeft(amusementGood); //good

        StoryNode vb = new StoryNode("volleyball .txt");
        _story.setRight(vb);
        vb.setRight(_story); //bad
        StoryNode vbGood = new StoryNode("vbGood.txt");
        vb.setLeft(vbGood); //good
    }

    public void receiveItem() {

    }

}
