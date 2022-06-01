public class LoveInterest extends Character{

    StoryNode _story;

    public LoveInterest(String name) {
        super(name);
    }

    //New in v2
    public void moveLeft() {
        _story = _story.getLeft();
        addLines(_story._cargo);
    }   
    
    //New in v2
    public void moveRight() {
        _story = _story.getRight();
        addLines(_story._cargo);
    }

    public StoryNode getStory() {
        return _story;
    }

    public void setStory() {

    }

    public void receiveItem() {

    }

}
