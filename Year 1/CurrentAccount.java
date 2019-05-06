// Inheritence Current Account class
// December 2012
// By: Fumiko Saito

public class CurrentAccount extends BankAccount {
	
	// ------ FIELDS ------ //
	public boolean debitCard;

	// ------- CONSTRUCTORS ------ //
	public CurrentAccount(String newAccountName, int newAccountNumber, boolean newDebitCard) {
	super(newAccountName, newAccountNumber);
	debitCard = newDebitCard;
	}
	

}
