// Comp101 - Tournament User Class
// December 2012
// By: Fumiko Saito

import java.util.*;

public class TournamentUser {

	
	// --- METHODS --- //
	public static void main(String[] args){
	
	// Attributes //
	Scanner keyboard = new Scanner(System.in);
	TournamentPlayer newTournamentPlayer;
	int noOfPlayers;
	int noOfRounds = 0;
	int numberOfWins = 0;
	int numberOfLosses = 0;
	int player1;
	int player2;
	String[] playerNames;
	boolean loop1 = true;
	boolean loop2 = true;
	
	
	// input the number of tournament players //
	System.out.println("Input the number of players for this tournament:");
	noOfPlayers = keyboard.nextInt();
	
	while (loop1 == true)
	{
		if (noOfPlayers <= 0) {
			System.out.println("Please input a number greater than 0");
			noOfPlayers = keyboard.nextInt();
		}
		
		else {
			loop1 = false;
		}
	}
	
	// defines the array size dependant on user
	playerNames = new String[noOfPlayers];
	
	
	// input the player names depending on the number of players inputted
	for (int index = 0; index < playerNames.length; index++)
	{
		System.out.print("Enter the name for player " + (index+1) + ": ");
		playerNames[index] = keyboard.next();
		
	}
		System.out.println("\nInitial state of the tournament:");
		
	for (int index = 0; index < playerNames.length; index++)
	{

		System.out.print("\n" + (index + 1) + ": " +playerNames[index]+ ": Played: " +noOfRounds+ ", Won: " + numberOfWins + ", Lost: " + numberOfLosses);
	}
	
	// Ask the user to pick which players to face off
	System.out.println("\n\nInput the first challenger (rank number):");
	player1 = keyboard.nextInt();
	
	System.out.println("Input the opponent (must be higher ranked!):");
	player2 = keyboard.nextInt();
	
	while (loop2 = true)
	{
		if (player1 <= player2) {
			System.out.print("Sorry " +player1+ " is ranked higher than " +player2);
			
				System.out.println("\n\nInput the first challenger (rank number):");
				player1 = keyboard.nextInt();
	
				System.out.println("Input the opponent (must be higher ranked!):");
				player2 = keyboard.nextInt();
		}
		
		else {
			loop2 = false;
		}
	}
			

	// call the constructor to input user values
	newTournamentPlayer = new TournamentPlayer (player1, player2, noOfPlayers);
	
	}
}	

