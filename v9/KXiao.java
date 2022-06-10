package v9;
public class KXiao extends LoveInterest{

    public KXiao() {
        super("KXiao");
        _source = "v9/KXiaoLines/";
        setup();
    }

    public void setup() {
        //root
        _story = new StoryNode(_source + "intro.txt");

        StoryNode cafe = new StoryNode(_source + "cafe/cafe.txt");
        _story.setLeft(cafe);

        StoryNode amusement = new StoryNode(_source + "amusement/amusement.txt");
        _story.setMid(amusement);

        StoryNode vb = new StoryNode(_source + "volleyball/volleyball.txt");
        _story.setRight(vb);
    }

    public void printBlurb() {
        String output = "";
        output += "The most alpha chad of the chads. They call him the GIGA-chad, pronounced GIIIIIIGGGGAAAAAAA CHAAAAAAAAD. 6'7," + "\n";
        output += "talks to multiple women, known playboy, needs to shower believing that his 3 dollar deodorant can last him throughout the year." + "\n";
        output += "He is known to be extremely arrogant and narcissistic, so perhaps being more confident and intelligent will show him that you are his equal?" +"\n";
        System.out.println(output);
    }

}
