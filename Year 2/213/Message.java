/** COMP213 Assignment 1 - Java implementation of MessageBoard (For Message)
* By: Fumiko Saito
* Username: U2FS & Student ID: 200784765
*/

/**
* The java class of a Message in Messageboard which simply returns the programmed
* fields which are the <i>Strings</i> for <b>messageSender</b> and <b>messageText</b>.
* The strings in this program are the same as the MessageBoardTest.maude document
* '<u>Fiona</u>' and '<u>Likes the smell of food</u>' should be printed.
*/

public class Message {

	/**
	* The message sender's name
	*/
	private final String messageSender;
	
	/**
	* The actual String of the message
	*/
	
	private final String messageText;

	/**
	* Creates a new <code>Message</code> instance with the given information
	*
	* @param messageSender the name of the sender
	* @param messageText the actual string of the message
	*/
	
	public Message(String messageSender, String messageText){
		
	this.messageSender = messageSender;
	this.messageText = messageText;
		
	}
	
	/**
	* Returns the sender's name
	*
	* @return messageSender
	*/
	
	public String getSender(){
	return messageSender;
	}
	
	/**
	* Returns the String of the message
	* 
	* @return messageText
	*/
	
	public String getMessage(){
	return messageText;
	}
	
	/**
	* To produce the same results as MessageBoardTest.maude by 
	* using print statements which would be '<u>Fiona</u>' and '<u>Likes the smell of food</u>'.
	*
	* @param args not used
	*/
	
	public static void main(String[] args){
		
	Message msg = new Message("Fiona", "Likes the smell of food");
	
	System.out.println(msg.getSender());
	System.out.println(msg.getMessage());
	
	}
}

