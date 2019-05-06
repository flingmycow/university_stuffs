import java.util.*;

public class List {
	
	private String topicTitle;
	private int topicID;
	
	public String getTitle(){
	return topicTitle;
	}
	
	public int getID(){
	return topicID;
	}
	
   public static void main(String args[]) {
      // create an array list
      ArrayList<String> theList = new ArrayList<String>();
      
      // add elements to the array list
      theList.add("This is title number 1 with array position 0");
      theList.add("This is title number 2 with array position 1");
      theList.add("This is title number 3 with array position 2");
      theList.add("This is title number 4 with array position 3");
      theList.add("This is title number 5 with array position 4");
      theList.add("My nephew");

      ArrayList<String> reList = new ArrayList<String>();  
      String topicTitle = "My nephew";
      for (String tt : theList){
      	      if (tt.contains(topicTitle)){
      	      	      reList.add(topicTitle);
      	      }
      }
      
      // display the array list
      System.out.println(theList.get(5)); //Matching the string and printing.
      System.out.println("The topic ID is " + theList.size());
   }
}
