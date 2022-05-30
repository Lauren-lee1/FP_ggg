import java.io.File;

public class StoryNode
{

  File _cargo;
  StoryNode _lt, _rt;

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


  /**
   * Returns the value stored in this tree node.
   */
  File getValue()
  {
    return _cargo;
  }


  /**
   * Sets the value of the left subtree of this node.
   */
  void setLeft( StoryNode theNewLeft )
  {
    _lt = theNewLeft;
  }


  /**
   * Sets the value of the right subtree of this node.
   */
  void setRight( StoryNode theNewRight )
  {
    _rt = theNewRight;
  }


  /**
   * Sets the value of this tree node.
   */
  void setValue( String newFilePath ) 
  {
    _cargo = new File(newFilePath);
  }

  public String toString() {
      return _cargo.getPath();
  }
}//end class
