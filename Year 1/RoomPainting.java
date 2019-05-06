// Room Painting Program
// By: Fumiko Saito

class RoomPainting {

  // FIELDS
  private double height;
  private double length;
  private double width;
  public double areaToPaint;
  public double amountOfPaint;
  public double numberOfTins;
  private double paintCost;
  private final double coverageOfPaint = 13.0;
  private final double paintPerTin = 5.0;
  private final double costPerTin = 15.43;

  // CONSTRUCTOR
  public RoomPainting (double newLength, double newHeight, double newWidth){
  	  length = newLength;
  	  height = newHeight;
  	  width = newWidth;
  	  areaToPaint = getareaToPaint();
  	  amountOfPaint = getamountOfPaint();
  	  numberOfTins = getnumberOfTins();
  	  paintCost = calculatepaintCost();
}
 
  // METHODS
  // Calculate area to paint
  	public double getareaToPaint(){
 	 return (2*((length + width) * height) + (length * width));
  }
 
  // Calclulate amount of paint needed
 	 public double getamountOfPaint() {
 	return (areaToPaint / coverageOfPaint);
  }
 
  // Calculate the number of tins needed
  	public double getnumberOfTins() {
 	return Math.ceil (amountOfPaint / paintPerTin);
  }
 
  // Calculate the cost of paint
 	 public double calculatepaintCost() {
  	return (numberOfTins * costPerTin);
  }

}
  
  
  


