public class Person{
  /*
  each man w different attributes wil have their own story line
  each story will follow a tree
  points are a stretch
  */

  private String _name;
  /*
  Boy 1:
  Boy 2:
  Boy 3:
  */

  private BST _story;

  public Person(String name){
    _name = name;
    _story = new BST();
  }

  public String getName(){
    return _name;
  }

  public BST getStory(){
    return _story;
  }

  public void setStory(){

  }

  /*
  traverse through story. Moving left or right based on user decisions
  */
  public void play(){

  }

}
