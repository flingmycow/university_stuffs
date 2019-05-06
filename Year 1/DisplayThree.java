// Display Three chance game program
// November 23, 2012
// By: Fumiko Saito
// Username: U2FS - Student ID: 200784765

public class DisplayThree {

	// ---- ATTRIBUTES ---- //
	public int playCost;
	public int noOfRounds;
	private int winnings;
	private int profit;
	private int totalWinnings;
	private int totalSpent;
	private int averageWinnings;
	private char[] symbols = new char[]{'A', 'B', 'C'};
	
	// ---- CONSTRUCTOR ---- //
	public DisplayThree (int newplayCost, int newNoOfRounds) {
	playCost = newplayCost;
	noOfRounds = newNoOfRounds;
	getLetters();
	}
	
	// ---- METHODS ---- //
	// 'Calculate' the random letter values
	public void getLetters() {
	int winnings = 0;
	int profit = 0;
	
	for (int loopParam = 1; loopParam - 1 < noOfRounds; loopParam++){
		int num1 = (int) (Math.random() * 3);
		int num2 = (int) (Math.random() * 3);
		int num3 = (int) (Math.random() * 3);

	totalSpent = ((loopParam) * playCost);
		
		if ((num1 == num2) && (num2 == num3)) {
			winnings = (3 * playCost);
			totalWinnings = (totalWinnings + winnings);
		}
		
			else if ((num1 != num2) && (num1 != num3) && (num2 != num3)) {
			winnings = (2 * playCost);
			totalWinnings = (totalWinnings + winnings);
			}
		
				else {
			winnings = 0;
			totalWinnings = (totalWinnings + winnings);
				}
		
	profit = (totalWinnings - totalSpent);
	averageWinnings = (totalWinnings / noOfRounds);
		
	// Print out what the values are
	System.out.print("\n------------------------------------");
	System.out.print("\n" +symbols[num1]);
	System.out.print(", " +symbols[num2]);
	System.out.print(", " +symbols[num3]);
	System.out.println("\n\nThis is round number: " +loopParam);
	System.out.println("\nThis round you have spent: " +playCost);
	System.out.println("\nThe total spent is: " +totalSpent);
	System.out.println("\nThe winnings for this round is: " +winnings);
	System.out.println("\nThe total winnings is: " +totalWinnings);
	System.out.println("\nThe profit or loss to date is: " +profit);
	System.out.println("------------------------------------");
	}
		
		System.out.println("\n\n*************************");
		System.out.println("Total profit or loss: " +profit);
		System.out.println("Total rounds played: " +noOfRounds);
		System.out.println("Average winnings: " +averageWinnings);
		System.out.println("*************************");
	}
}

