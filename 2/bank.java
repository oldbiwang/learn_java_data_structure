class BankAccount {
	private double balance; //	account balance

	 // constructor
	public BankAccount(double openingBalance) {
		balance = openingBalance;
	}

	//makes deposit
	public void deposit(double amount) {
		balance = balance + amount;
	}

	// makes withdrawal
	public void withdraw(double amount) {
		balance = balance - amount;
	}

	// display balance
	public void display() {
		System.out.println("balance = " + balance);
	}
}  // end class BankAccount
////////////////////////////////////////////////
class BankApp {
	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount(100.00);  // create acct

		System.out.print("Before transactions, ");
		ba1.display();      // display balance
		ba1.deposit(74.35);	// make deposit
		ba1.withdraw(20.00);	// make withdrawal

		System.out.print("After transactions, ");
		ba1.display();		// display balance
	}	// end main()
}	// end class BankApp