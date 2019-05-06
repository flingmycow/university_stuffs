// Bank Account Class
// December 2012
// By: Fumiko Saito

public class BankAccount {

	// Attributes
	protected String accountName;
	protected int accountNumber;
	protected double accountBalance;
	public double accountDeposit1 = 0;
	public double accountDeposit2 = 0;
	public double accountWithdraw1 = 0;
	public double accountWithdraw2 = 0;
	protected final double OVERDRAFT_LIMIT = 100.0;
	protected final double ACCOUNT_FEE = 12.00;
	
	// Constructor
	public BankAccount (String newAccountName, int newAccountNumber){
		accountName = newAccountName;
		accountNumber = newAccountNumber;
		accountBalance = getAccountBalance();
	}
	
	public double getAccountBalance() {
	 return ((accountBalance + accountDeposit1 + accountDeposit2) - (accountWithdraw1 + accountWithdraw2));
	}
}
