// Inheritence Savings Account class
// December 2012
// By: Fumiko Saito

public class SavingsAccount extends BankAccount {
	
	// ------ FIELDS ------ //
	// Subclass changes a constant's value //
	public final double OVERDRAFT_LIMIT = 0.0;
	public final double RATE_OF_INTEREST = .8;

	// ------- CONSTRUCTORS ------ //
	public SavingsAccount(String newAccountName, int newAccountNumber) {
	super(newAccountName, newAccountNumber);
	}


	
}
