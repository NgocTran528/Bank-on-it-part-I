public class Customer extends User {
	protected CheckingAccount checking = new CheckingAccount();
	protected SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		Customer c = new Customer();
		if (c.login()){
			c.start();
		} // end if
	} // end main
	
	public Customer(){
		userName = "Alice";
		PIN = "0000";
	} // end constructor
	
	public Customer(String name, String pin){
		userName = name;
		PIN = pin;
	} // end constructor
	
	public String menu(){
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println();
		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) change PIN");
		System.out.print("Action (0-3): ");
		return input.nextLine();
	} // end menu
	
	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String choice = menu();
			if (choice.equals("1")){
				System.out.println("Checking Account");
				checking.start();
			} else if (choice.equals("2")){
				System.out.println("Savings Account");
				savings.start();
			} else if (choice.equals("3")){
				changePIN();
			} else if (choice.equals("0")){
				keepGoing = false;
			} // end if
		} // end while
	} // end start
	
	public void changePIN(){
		System.out.print("New PIN: ");
		PIN = input.nextLine();
	} // end changePIN
	
	public String getReport(){
		return userName + " checking: " + checking.getBalanceString() + " savings: " + savings.getBalanceString();
	} // end getReport
} // end Customer
