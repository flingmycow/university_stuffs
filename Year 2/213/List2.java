import java.util.*;

public class List2{

	
	public String thisWord = "HELLO!";
	
	public static void main(String[] args){
			
	ArrayList topicList = new ArrayList();
	
	topicList.add("item");
	topicList.add(thisWord);
	
	int size = topicList.size();
	
	int index = topicList.indexOf("Item");
	
	for (int i = 0; i < topicList.size(); i++)
	System.out.println("Item " + i + " : ");
	
	
	if(topicList.contains(thisWord)){
		System.out.println("Found! " + thisWord);
	}
	
	
	boolean result = topicList.isEmpty();

	if(topicList.size() == 0){
	System.out.println("ArrayList is empty");
	}

	topicList.remove();
	topicList.remove(thisWord);
	
	}
}
