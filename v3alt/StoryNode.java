package v3alt;
import java.io.File;

public class StoryNode
{

  File _cargo;
  StoryNode _lt, _rt, _mid;

  StoryNode( String pathToFile )
  {
    _cargo = new File(pathToFile);
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

  
}//end class
