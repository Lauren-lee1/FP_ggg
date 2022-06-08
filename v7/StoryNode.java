package v7;
import java.io.File;

public class StoryNode
{

  File _cargo;
  StoryNode _lt, _rt, _mid;
  String _path;
  String _requirement;

  StoryNode( String pathToFile )
  {
    _cargo = new File(pathToFile);
    _path = pathToFile;
  }

  StoryNode getLeft()
  {
    return _lt;
  }

  StoryNode getRight()
  {
    return _rt;
  }

  StoryNode getMid()
  {
    return _mid;
  }

  int getNumberOfChildren() {
      int counter = 0;
      if (getLeft() != null) {
          counter++;
      }
      if (getMid() != null) {
        counter++;
      }
      if (getRight() != null) {
        counter++;
      }

      return counter;
  }

  File getValue()
  {
    return _cargo;
  }

  void setLeft( StoryNode theNewLeft )
  {
    _lt = theNewLeft;
  }

  void setRight( StoryNode theNewRight )
  {
    _rt = theNewRight;
  }

  void setMid(StoryNode theNewMid)
  {
    _mid = theNewMid;
  }

  void setValue( String newFilePath )
  {
    _cargo = new File(newFilePath);
  }

  void setRequirement(String requirement) {
      _requirement = requirement;
  }

  boolean allows(Player player) {
      int index = _requirement.indexOf(">");
      
      if (index != -1) {
          String stat = _requirement.substring(0, index);
          String number = _requirement.substring(index + 1);
          stat = stat.trim();
          number = number.trim();

          if (stat.equals("intelligence")) {
            return (player.getIntelligence() > Integer.parseInt(number));
          }
          if (stat.equals("confidence")) {
            return (player.getConfidence() > Integer.parseInt(number));
          }
          if (stat.equals("kindness")) {
            return (player.getKindness() > Integer.parseInt(number));
          }  
      }

      return false;
  }

  public String toString() {
      String name = _path;
      while (name.indexOf("/") != -1) {
          name = name.substring(name.indexOf("/") + 1);
      }

      return name.substring(0, name.indexOf("."));
  }
  
}//end class
