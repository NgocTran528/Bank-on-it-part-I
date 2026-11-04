public class SavingsAccount extends CheckingAccount {
	protected double interestRate = 0.05;

	public static void main(String[] args){
		SavingsAccount s = new SavingsAccount();
		s.start();
	} // end main
	
	public SavingsAccount(){
		super();
	} // end constructor
	
	public SavingsAccount(double b){
		super(b);
	} // end constructor
	
	public void calcInterest(){
		balance = balance + balance *interestRate;
	} // end calcInterest
	
	public void setInterestRate(double r){
		interestRate = r;
	} // end getInterestRate 
	
	public double getInterestRate(){
		return interestRate;
	} // end getInterestRate
} // end SavingsAccount
