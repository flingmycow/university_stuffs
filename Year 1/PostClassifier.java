// Post Office Classifer Program
// November 2012
// By: Fumiko Saito (U2FS)

public class PostClassifier {

// ATTRIBUTES
  private int length;
  private int width;
  private int thickness;
  private int weight;

// CONSTRUCTOR
  public PostClassifier (int newLength, int newWidth, int newThickness, int newWeight){
	length = newLength;
	width = newWidth;
	thickness = newThickness;
	weight = newWeight;
	gettypeOfMail();
  }
	
// METHODS - Determining type of mail based on input values
  public void gettypeOfMail(){
  
  	  if (length <= 240 && width <= 165 && thickness <= 5 && weight <= 100) 
	  {
	  	  System.out.println("\n\nBased on the input values, this is a Letter");
  	  }
	  
   	  else if (length <= 353 && width <= 250 && thickness <= 25 && weight <= 750)
   	  { 
   	  	  System.out.println("\n\nBased on the input values, this is a Large Letter");
   	  }
   	  	   
   	  else if (length <= 610 && width <= 460 && thickness <= 460 && weight <= 1000)
   	  {
   	  	  System.out.println("\n\nBased on the input values, this is a Packet");
   	  }   	
   	  else if (length <= 1500 && width <= 1500 && thickness <= 1500 && weight <= 20000)	
   	  {	
   	  	System.out.println("\n\nBased on the input values, this is a Parcel");
   	  }
   	  
   	  else {
   	  System.out.println("\n\nYour mail is too large/doesn't comply with any of the mail types");
   	  }
   	  	    	
   	  	
     }
}
   	  
  				 
  






