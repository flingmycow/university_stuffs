// Display Three Chance Game Program - User Class
// November 22, 2012
// By: Fumiko Saito
// Username: U2FS - Student ID: 200784765

import java.util.Scanner;	

public class DisplayThreeUser {

// ------ METHODS ------ //

public static void main(String[] args){

	// Create Scanner Class Instance
	  Scanner input = new Scanner(System.in);
	  DisplayThree newDisplayThree;
	  int playCost;
	  int noOfRounds;
	  int winnings;
	  int profit;
	  int totalWinnings;
	  int totalSpent;
	  boolean loop1 = true;
	  boolean loop2 = true;

	  
	// Input Values for PlayCost and Number of Rounds
	System.out.println("\nInput the cost of playing (integer)");
	playCost = input.nextInt();
	while(loop1 == true) 
		{
			if (playCost <= 0) {
					System.out.println("Please input a value greater than 0");
					playCost = input.nextInt();
			}
			
			else {
				loop1 = false;
			}
		}

	System.out.println("Input the number of rounds you want to play");
	noOfRounds = input.nextInt();
	while(loop2 == true)
		{
			if (noOfRounds <= 0) {
					System.out.println("Please input value greater than 0");
					noOfRounds = input.nextInt();
			}
			
			else {
				loop2 = false;
			}
		}

	// Call Constructor with user input
	newDisplayThree = new DisplayThree (playCost, noOfRounds);
	
	}
}
