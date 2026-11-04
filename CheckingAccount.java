import java.util.Scanner;

public class CheckingAccount implements HasMenu {
	protected double balance;
	protected Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		CheckingAccount c = new CheckingAccount();
		c.start();
	} // end main
	
	public CheckingAccount(){
		balance = 0;
	} // end constructor
	
	public CheckingAccount(double b){
		balance = b;
	} // end constructor
	
	public String menu(){
		System.out.println();
		System.out.println("Account menu");
		System.out.println();
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal");
		System.out.println();
		System.out.println("Please enter 0-3: ");
		return input.nextLine();
	} // end menu
	
	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String choice = menu();
			if (choice.equals("1")){
				checkBalance();
			} else if (choice.equals("2")){
				makeDeposit();
			} else if (choice.equals("3")){
				makeWithdrawal();
			} else if (choice.equals("0")){
				keepGoing = false;
			} // end if
		} // end while
	} // end start
	
	public double getBalannce(){
		return balance;
	} // end getBalance
	
	public String getBalanceString(){
		return String.format("$%.2f", balance);
	} // end getBalanceString
	
	public void setBalance(double b){
		balance = b;
	} // end setBalance
	
	public void checkBalance(){
		System.out.println("Checking balance...");
		System.out.println("Current balance: " + getBalanceString());
	} // end checkBalance
	
	private double getDouble(){
		double value = 0;
		try {
			value = Double.parseDouble(input.nextLine());
		} catch (Exception e){
			System.out.println("not a number");
		} // end try
		return value;
	} // end getDouble
	
	public void makeDeposit(){
		System.out.println("Making a deposit...");
		System.out.print("How much to deposit? ");
		double amount = getDouble();
		balance = balance + amount;
		System.out.println("New balance: " + getBalanceString());
	} // end makeDeposit
	
	public void makeWithdrawal(){
		System.out.println("Making a withdrawal...");
		System.out.print("How much to withdraw? ");
		double amount = getDouble();
		if (amount > balance){
			System.out.println("not enough money");
		} else {
			balance = balance - amount;
		} // end if
	} // end makeWithdrawal
} // end CheckingAccount
