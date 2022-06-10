
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

        StoryNode what = new StoryNode(_source + "what/what.txt");
        _story.setRight(what);
    }

    public void printBlurb() {
        String output = "";
        output += "A league player. Perhaps intelligence isn’t the way to go with this man, but kindness and being confident will help? I don’t even" + "\n";
        output += "know man league players… Don’t go too hard with the athletic side or else there might be an accident..." + "\n";
        System.out.println(output);
    }

}
