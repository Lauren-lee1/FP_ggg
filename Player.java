
public class Player{

  String _name;
  int _confidence;
  int _intelligence;
  int _kindness;

  public Player(String name) {
      _name = name;
      _confidence = 0;
      _intelligence = 0;
      _kindness = 0;
  }

  public void printStats() {
      System.out.println(_name);
      System.out.println("=================");
      System.out.println("confidence: " + _confidence);
      System.out.println("intelligence: " + _intelligence);
      System.out.println("kindness: " + _kindness);
      System.out.println("=================");
  }

  public void setConfidence(int confidence) {
    _confidence = confidence;
  }

  public void setIntelligence(int intelligence) {
    _intelligence = intelligence;
  }

  public void setKindness(int kindness) {
    _kindness = kindness;
  }

  public int getConfidence() {
    return _confidence;
  }

  public int getIntelligence() {
    return _intelligence;
  }

  public int getKindness() {
    return _kindness;
  }

  public String getName() {
    return _name;
  }

}
