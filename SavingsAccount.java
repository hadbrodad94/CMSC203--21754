
public class SavingsAccount extends BankAccount{
	 private double rate = 2.5;
	 private int savingsNumber = 0;
	 private String accountNumber;
	 public SavingsAccount(String name, double iBalance) {
		 super(name,iBalance);
		 this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
	 }
	public void postInterest() {
		double updateBalance =super.getBalance() * (rate/(100*12));
		super.deposit(updateBalance);
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
	public SavingsAccount(SavingsAccount savingsAcc, double iBalance) {
		//savingsAcc.getAccountNumber() = this.getAccountNumber();
		super(savingsAcc,iBalance);
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
	}
}
/*
Used to compare outputs:

Account Number 100001-10 belonging to Benjamin Franklin
Initial balance = $1000.00
After deposit of $500.00, balance = $1500.00
After withdrawal of $1000.00, balance = $499.85

Account Number 100002-0 belonging to William Shakespeare
Initial balance = $400.00
After deposit of $500.00, balance = $900.00
Insuffient funds to withdraw $1000.00, balance = $900.00
After monthly interest has been posted, balance = //$901.88

Account Number 100002-//1 belonging to William Shakespeare
Initial balance = $5.00
After deposit of $500.00, balance = $505.00
Insuffient funds to withdraw $1000.00, balance = $505.00

Account Number 100003-10 belonging to Isaac Newton

*/