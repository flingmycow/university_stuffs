// Comp101 - Tournament Java Program
// December 2012
// By: Fumiko Saito

import java.util.*;

public class TournamentPlayer{
	
	// --- Attributes --- //
	private int playerNumber;
	private int noOfPlayers;
	private int noOfRounds;
	private int numberOfWins;
	private int numberOfLosses;
	private int player1;
	private int player2;
	public String[] playerNames;
	
	// --- Constructors --- //
	public TournamentPlayer (int newNoOfPlayers, int newPlayer1, int newPlayer2) {
		player1 = newPlayer1;
		player2 = newPlayer2;
		noOfPlayers = newNoOfPlayers;
		determineWinnings();
	}
	
	// --- Methods --- //	
	// method to calculate, and determine who wins the round
	public void determineWinnings() {
	
	playerNames = new String[noOfPlayers];	
		
	int numberOfWins = 0;
	int numberOfLosses = 0;
	int noOfRounds = 0;
	
	for (int loopParam = 1; loopParam < noOfRounds; loopParam++) {
		int num1 = (int) (Math.random() * 2);
	

		if (num1 == 0) {
			numberOfLosses = (numberOfLosses + 1);
			noOfRounds = (noOfRounds + 1);
			
			System.out.println(+ player1 + "has lost this round");
		}
		
		else  {
			numberOfWins = (numberOfWins + 1);
			noOfRounds = (noOfRounds + 1);
			
			System.out.println(+ player1 + "has won this round");
		}	
	
	// Print out new results
	for (int index = 0; index < playerNames.length; index++)
	{
		System.out.print("\n" + (index + 1) + ": " +playerNames[index]+ ": Played: " +noOfRounds+ ", Won: " + numberOfWins + ", Lost: " + numberOfLosses);
	}
	
	}
	}	
}
