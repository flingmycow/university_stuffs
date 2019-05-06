/** COMP213 Assignment 1 - Java implementation of MessageBoard (For Topic)
* By: Fumiko Saito
* Username: U2FS & Student ID: 200784765
*/

/**
* The java class of a Topic in Messageboard which simply returns the programmed
* fields first is a <i>String</i> called <b>topicTitle</b> and an 
* <i>int</i> <b>topicID</b>. The string and in this program are the same 
* as the MessageBoardTest.maude document which should output the following
* '<u>My Nephew</u>' and '<u>15</u>.
*/


public class Topic {

	/**
	* The topic's title which is a String
	*/
	private final String topicTitle;
	
	/**
	* The identifier int number each topic has
	*/
	private final int topicID;

	/**
	* Creates a new <code>Topic</code> instance with the given information
	*
	* @param topicTitle the topic's title
	* @param topicID the identifying int number each topic will have
	*/
	public Topic(String topicTitle, int topicID){
		
	this.topicTitle = topicTitle;
	this.topicID = topicID;
	}
	
	/**
	* Returns the topic's title
	*
	* @return topicTitle
	*/
	public String getTitle(){
	return topicTitle;
	}
	
	/**
	* Returns the topic's identifying int number
	*
	* @return topicID
	*/
	public int getID(){
	return topicID;
	}
	
	/**
	* To produce the same results as MessageBoardTest.maude by using print statements
	* which should output '<u>My nephew</u>' and '<u>15</u>'.
	*
	* @param args not used
	*/
	public static void main(String[] args){
		
	Topic t = new Topic("My Nephew", 15);
	
	System.out.println(t.getTitle());
	System.out.println(t.getID());
	
	}
}

