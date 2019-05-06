// Ladder Calculation Program
// November 2012
// By: Fumiko Saito

public class LadderCalculation {

  // ATTRIBUTES
  private double topAngle;
  private double verticalHeight;
  private double bottomAngle;
  private double ladderLength;
  private double floorLength;
  private double dropTime;
  private final double accelerationOfGravity = 9.8;
  
  // CONSTRUCTOR
  public LadderCalculation (double newtopAngle, double newverticalHeight){
  	 topAngle = newtopAngle;
  	 verticalHeight = newverticalHeight;
  	 bottomAngle = getbottomAngle();
  	 ladderLength = getladderLength();
  	 floorLength = getfloorLength();
  	 dropTime = getdropTime();
  }
  
  // METHODS
  // Calculate bottom angle (angle between the ground and ladder)
  	public double getbottomAngle(){
  	 return (90 - topAngle);
  }  	 
  
  // Calculate the ladder length 
  	public double getladderLength(){
  	 return (verticalHeight / (Math.cos(Math.toRadians(topAngle))));
  }
  	 
  // Calculate the length of the floor
  	public double getfloorLength(){
  	 return (verticalHeight * (Math.tan(Math.toRadians(topAngle))));
  }
  
  // Calculate the drop time of an object
  	public double getdropTime(){
  	 return Math.sqrt((2 * verticalHeight) / accelerationOfGravity);
  }
}
