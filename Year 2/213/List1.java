import java.util.*;

public class List1 {
	
	public String topicTitle;
	public String messages;
	public int topicID;
	
   public static void main(String args[]) {
      // create an array list
      ArrayList theList = new ArrayList();
      System.out.println("Initial size of theList: " + theList.size());

      // add elements to the array list
      theList.add("G");
      theList.add("F");
      theList.add(2);
      System.out.println("Size of theList after additions: " + theList.size());

      // display the array list
      System.out.println("Contents of theList: " + theList);
      // Remove elements from the array list
      theList.remove("F");
      theList.remove(2);
      System.out.println("Size of theList after deletions: " + theList.size());
      System.out.println("Contents of theList: " + theList);
   }
}
