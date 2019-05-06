public class LinkNode {

	// fields
	private String messageSender;
	private String messageText;
	private String topicTitle;
	private int topicID;
	private LinkNode next;
	
	// ListNode constructor
	public LinkNode(String mS, String mT, String tT, int tID){
		messageSender = mS;
		messageText = mT;
		topicTitle = tT;
		topicID = tID;
	}
	

	public void printLinkNode(){
		System.out.println("{" + messageSender + ", " + messageText + 
			", " + topicTitle + ", " + topicID);
	}
	
	
	
public class SortedTopicList {
	
	private LinkNode head;
	
	// SortedTopicList constructor 
	public SortedTopicList() {
		head = null;
	}
	
	// Returns true if list is empty
	public boolean isEmpty(){
		return head == null;
	}
	
	// Inserts a new LinkNode at the beginning (head) of the list
	public void insertNewTopic(String mS, String mT, String tT, int tID){
		LinkNode link = new LinkNode(mS, mT, tT, tID);
		link.nextLinkNode = head;
		head = link;
	}
}

		
class Test {
	public void main(String[] args) {
		
		SortedTopicList list = new SortedTopicList();
		
		list.insert("Bo", "First post", "Topic 0", 0);
		list.insert("Mary", "Mary's new post", "Topic 1", 5);
		list.insert("John", "John's post", "Topic 2", 7);
		
		System.out.println(list);

		while(!list.isEmpty()) {
		    LinkNode deletedLink = list.delete();
		    System.out.print("deleted: ");
		    deletedLink.printLinkNode();
		    System.out.println("");
	    }
	    list.printList();
    }
}
}
