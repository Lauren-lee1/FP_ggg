package v4alt;
import java.io.File;

public class StoryNode
{

  File _cargo;
  StoryNode _lt, _rt, _mid;
  String path;

  StoryNode( String pathToFile )
  {
    _cargo = new File(pathToFile);
    path = pathToFile;
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

  public String toString() {
      String name = path;
      while (name.indexOf("/") != -1) {
          name = name.substring(name.indexOf("/") + 1);
      }

      return name.substring(0, name.indexOf("."));
  }
  
}//end class
